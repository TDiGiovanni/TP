#include "Client.hpp"
#include <unistd.h>

Client::Client(NetworkConnection &connection)
{
	this->mNetworkConnection = connection;
	this->mIsFirstMessage = true;
	this->mClientIsWorking = true;
	this->mDecoder = new ProtocolDecoder();
	this->mEncoder = NULL; // Needs UserName, initialization in pullFromClient.
	this->mIPC = IPC::getInstance();
	this->mUserName = UNDEFINED_NAME;
	this->mMutex = PTHREAD_MUTEX_INITIALIZER;
}

void Client::loop()
{
	// Starting threads to push and pull information between client and server.
	pthread_t pushingThreadId, pullingThreadId;
	pthread_create(&pullingThreadId, NULL, pullingThread, this);
	pthread_create(&pushingThreadId, NULL, pushingThread, this);

	pthread_join(pullingThreadId, NULL);
	pthread_join(pushingThreadId, NULL);
}

Client::~Client()
{
	delete this->mDecoder;
	delete this->mEncoder;
	pthread_mutex_destroy(&(this->mMutex));
}

void *Client::pushingThread(void *context)
{
	Client *c = (Client *)context;

	while (c->mClientIsWorking)
	{
		// Blocks the caller if the semaphore value is less than 1.
		// Reminder: the semaphore equals to the number of new messages.
		pthread_mutex_lock(&(c->mMutex));
		std::cout << "[PUSH|" << c->mUserName << "] Waiting P1"
				  << std::endl;
		pthread_mutex_unlock(&(c->mMutex));
		c->mIPC->operateOnSemaphore(-1); // P1
		pthread_mutex_lock(&(c->mMutex));
		std::cout << "[PUSH|" << c->mUserName << "] P1 Unlocked"
				  << std::endl;
		pthread_mutex_unlock(&(c->mMutex));

		// From here, we have at least one incoming message to push to the
		// client. Giving hand to pushToClient.
		pthread_mutex_lock(&(c->mMutex));
		std::cout << "[PUSH|" << c->mUserName << "] Pushing all messages"
				  << std::endl;
		c->pushToClient();
		pthread_mutex_unlock(&(c->mMutex));

		// Waits for all clients to update, to make sure we don't update
		// twice and prevent another client from updating
		c->mIPC->operateOnSemaphore(0);
	}

	pthread_exit(NULL);
}

void *Client::pullingThread(void *context)
{
	Client *c = (Client *)context;

	while (c->mClientIsWorking)
	{
		// Handling message reception.
		pthread_mutex_lock(&(c->mMutex));
		std::cout << "[PULL|"
				  << c->mUserName
				  << "] Waiting for reception"
				  << std::endl;
		pthread_mutex_unlock(&(c->mMutex));

		std::string msg = c->mNetworkConnection.receive();

		pthread_mutex_lock(&(c->mMutex));
		std::cout << "[PULL|"
				  << c->mUserName << "] <<< "
				  << msg
				  << std::endl;

		EncodedMessage encodedMsg = c->mDecoder->decodeFromReceive(msg);

		if (encodedMsg.type == Quit)
		{
			c->mIPC->setNumberOfClients(c->mIPC->getNumberOfClients() - 1);
			c->setClientIsWorking(false);
		}

		// Giving hand to pullFromClient.
		c->pullFromClient(encodedMsg);
		pthread_mutex_unlock(&(c->mMutex));
	}

	pthread_exit(NULL);
}

// Sending data to client with mNetworkConnection
void Client::pushToClient()
{
	// Just sending ALL messages to client.
	// If the client is authentified so we have access to the Encoder.
	if (this->mEncoder != NULL)
	{

		std::string msg = mEncoder->encodeForSend(mIPC->getLastMessage());
		this->mNetworkConnection.send(msg);
		std::cout << "[PUSH|"
				  << this->mUserName
				  << "] >>> "
				  << msg
				  << std::endl;

		std::cout << "[PUSH|"
				  << this->mUserName
				  << "] All messages are sent"
				  << std::endl;
	}
}

// Get message from client and append it to IPC with addMessage(msg).
// First message received from client is treated as UserName.
void Client::pullFromClient(EncodedMessage msg)
{
	if (this->mIsFirstMessage)
	{
		this->mIsFirstMessage = false;
		this->mUserName = msg.userName;
		// Initializing encoder
		this->mEncoder = new ProtocolEncoder(this->mUserName);
	}
	// Operation on semaphore is done in addMessage(msg).
	if (msg.type == Command::ChatMessage) {
		mIPC->addMessage(msg);
		std::cout << "[PULL|"
				  << this->mUserName
				  << "] New message added to IPC"
				  << std::endl;
	} else if (msg.type == Command::Quit) {
		// We send the same received message to the client.
		// This way, the client will disconnect.
		std::string stringMsg = mEncoder->encodeForSend(msg);
		this->mNetworkConnection.send(stringMsg);
		std::cout << "[PUSH|"
				  << this->mUserName
				  << "] QUIT MESSAGE "
				  << std::endl;
		mIPC->setNumberOfClients(mIPC->getNumberOfClients() - 1);
	}
}

void Client::setClientIsWorking(bool b)
{
	this->mClientIsWorking = b;
}