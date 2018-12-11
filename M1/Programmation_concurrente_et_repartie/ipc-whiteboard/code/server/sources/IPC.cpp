#include "IPC.hpp"

IPC *IPC::instance = nullptr;

// Private constructor
IPC::IPC()
{
    this->mMutex = PTHREAD_MUTEX_INITIALIZER;

    // Creating key file
    std::ofstream keyfile(IPC_PATH_FILE);
    keyfile.close();

    // SEMAPHORE ARRAY
    // Key
    key_t semKey = ftok(IPC_PATH_FILE, 25);
    if (semKey == -1)
        throw std::runtime_error("Can't create the semaphore key.");

    // Creating
    int semId = semget(semKey, 1, IPC_CREAT | 0666);
    if (semId == -1)
        throw std::runtime_error("Can't create the semaphore array.");
    this->semId = semId;

    // Initializing
    union semun init;
    init.val = 0;
    if (semctl(semId, 0, SETVAL, init) == -1)
        throw std::runtime_error("Can't initialise the semaphore array.");

    // SHARED MEMORY FOR MESSAGES
    // Key
    key_t shmMessagesKey = ftok(IPC_PATH_FILE, 26);
    if (shmMessagesKey == -1)
        throw std::runtime_error("Can't create the shared memory for messages key.");

    // Creating
    int shmMessagesId = shmget(shmMessagesKey, MAX_MESSAGE_NUMBER * sizeof(EncodedMessage), IPC_CREAT | 0666);
    if (shmMessagesId == -1)
        throw std::runtime_error("Can't create the shared memory for messages.");
    this->shmMessagesId = shmMessagesId;

    // Attaching
    EncodedMessage *messageArray = (EncodedMessage *)shmat(shmMessagesId, NULL, 0);
    if (messageArray == (void *)-1)
        throw std::runtime_error("Can't attach to the shared memory for messages.");
    this->messageArray = messageArray;

    // SHARED MEMORY FOR NUMBER OF CLIENTS
    // Key
    key_t shmClientsKey = ftok(IPC_PATH_FILE, 27);
    if (shmClientsKey == -1)
        throw std::runtime_error("Can't create the shared memory for number of clients key.");

    // Creating
    int shmClientsId = shmget(shmClientsKey, sizeof(int), IPC_CREAT | 0666);
    if (shmClientsId == -1)
        throw std::runtime_error("Can't create shared memory for number of clients.");
    this->shmClientsId = shmClientsId;

    // Attaching
    int *numberClients = (int *)shmat(shmClientsId, NULL, 0);
    if (numberClients == (void *)-1)
        throw std::runtime_error("Can't attach to the shared memory for number of clients.");
    this->numberClients = numberClients;

    // Setting value
    this->setNumberOfClients(0);

    // SHARED MEMORY FOR CURRENT INDEX
    // Key
    key_t shmCurrentIndexKey = ftok(IPC_PATH_FILE, 28);
    if (shmCurrentIndexKey == -1)
        throw std::runtime_error("Can't create the shared memory for current index.");

    // Creating
    int shmCurrentIndexId = shmget(shmCurrentIndexKey, sizeof(int), IPC_CREAT | 0666);
    if (shmCurrentIndexId == -1)
        throw std::runtime_error("Can't create shared memory for current index.");
    this->shmCurrentIndexId = shmCurrentIndexId;

    // Attaching
    int *currentIndex = (int *)shmat(shmCurrentIndexId, NULL, 0);
    if (currentIndex == (void *)-1)
        throw std::runtime_error("Can't attach to the shared memory for current index.");
    this->currentIndex = currentIndex;

    // Setting value
    *(this->currentIndex) = 0;
}

// Destructor
IPC::~IPC()
{
    pthread_mutex_destroy(&(this->mMutex));
}

// Properly terminates all the IPC created
void IPC::destroy()
{
    // Destroying the semaphore array
    if (semctl(semId, 0, IPC_RMID) == -1)
        throw std::runtime_error("Can't destroy the semaphore array.");

    // Detaching from the shared memory for messages
    if (shmdt((void *)messageArray) == -1)
        throw std::runtime_error("Can't detach from the shared memory for messages.");

    // Destroying the shared memory for messages
    if (shmctl(this->shmMessagesId, IPC_RMID, NULL) == -1)
        throw std::runtime_error("Can't destroy the shared memory for messages.");

    // Detaching from the shared memory for number of clients
    if (shmdt((void *)numberClients) == -1)
        throw std::runtime_error("Can't detach from the shared memory for number of clients.");

    // Destroying the shared memory for number of clients
    if (shmctl(this->shmClientsId, IPC_RMID, NULL) == -1)
        throw std::runtime_error("Can't destroy the shared memory for number of clients.");

    // Detaching from the shared memory for current index
    if (shmdt((void *)currentIndex) == -1)
        throw std::runtime_error("Can't detach from the shared memory for current index.");

    // Destroying the shared memory for current index
    if (shmctl(this->shmCurrentIndexId, IPC_RMID, NULL) == -1)
        throw std::runtime_error("Can't destroy the shared memory for current index.");
}

// Returns the singleton instance of IPC (creates it if needed)
IPC *IPC::getInstance()
{
    if (!instance)
        instance = new IPC();

    return instance;
}

// Adds a message to the shared memory
void IPC::addMessage(EncodedMessage msg)
{
    pthread_mutex_lock(&(this->mMutex));
    this->messageArray[*(this->currentIndex)].message = msg.message;
    this->messageArray[*(this->currentIndex)].messageSize = msg.messageSize;
    this->messageArray[*(this->currentIndex)].sendTime = msg.sendTime;
    this->messageArray[*(this->currentIndex)].type = msg.type;
    this->messageArray[*(this->currentIndex)].userName = msg.userName;
    this->messageArray[*(this->currentIndex)].userNameSize = msg.userNameSize;

    // Incrementation of index
    if (*(this->currentIndex) == MAX_MESSAGE_NUMBER - 1)
        *(this->currentIndex) = 0;
    else
        *(this->currentIndex) = *(this->currentIndex) + 1;
    pthread_mutex_unlock(&(this->mMutex));

    // Operation on semaphore
    this->operateOnSemaphore(*(this->numberClients)); // We add the number of clients so that every one of them can update once
}

// Sets the number of clients in the shared memory to n
void IPC::setNumberOfClients(int n)
{
    *(this->numberClients) = n;
}

// Gets the number of clients in the shared memory
int IPC::getNumberOfClients()
{
    return *(this->numberClients);
}

// Returns all messages stored (from oldest to most recent)
std::vector<EncodedMessage> IPC::getAllMessages()
{
    pthread_mutex_lock(&(this->mMutex));
    std::vector<EncodedMessage> result;
    int tempIndex = *(this->currentIndex);
    EncodedMessage currentMessage;

    do
    {
        if (!this->messageArray[tempIndex].message.empty())
        {
            currentMessage.message = this->messageArray[tempIndex].message;
            currentMessage.messageSize = this->messageArray[tempIndex].messageSize;
            currentMessage.sendTime = this->messageArray[tempIndex].sendTime;
            currentMessage.type = this->messageArray[tempIndex].type;
            currentMessage.userName = this->messageArray[tempIndex].userName;
            currentMessage.userNameSize = this->messageArray[tempIndex].userNameSize;

            result.push_back(currentMessage);
        }

        if (tempIndex < MAX_MESSAGE_NUMBER - 1)
            tempIndex++;
        else
            tempIndex = 0;
    } while (tempIndex != *(this->currentIndex));
    pthread_mutex_unlock(&(this->mMutex));
    return result;
}

// Returns the n most recent message stored
std::vector<EncodedMessage> IPC::getLastMessages(int n)
{
    std::vector<EncodedMessage> result;

    while (n > 0)
    {
        if ((*(this->currentIndex) - n) < 0)
            result.push_back(this->messageArray[MAX_MESSAGE_NUMBER - (*(this->currentIndex) - n)]);
        else
            result.push_back(this->messageArray[*(this->currentIndex) - n]);

        n--;
    }

    return result;
}

// Returns the most recent message stored
EncodedMessage IPC::getLastMessage()
{
    EncodedMessage msg;
    pthread_mutex_lock(&(this->mMutex));
    if (*(this->currentIndex) == 0)
        msg = this->messageArray[MAX_MESSAGE_NUMBER - 1];
    else
        msg = this->messageArray[*(this->currentIndex) - 1];
    pthread_mutex_unlock(&(this->mMutex));
    return msg;
}

// Calls an operation on the semaphore array (adding or removing "value")
void IPC::operateOnSemaphore(int value)
{
    // Operation on semaphore
    struct sembuf operation;
    operation.sem_num = 0;
    operation.sem_op = value;
    operation.sem_flg = SEM_UNDO;

    if (semop(this->semId, &operation, 1) == -1)
        throw std::runtime_error("Can't operate on semaphore array.");
}