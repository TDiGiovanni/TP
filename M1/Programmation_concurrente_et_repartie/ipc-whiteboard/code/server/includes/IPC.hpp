#ifndef IPC_HPP
#define IPC_HPP

#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>
#include <errno.h>

#include <stdexcept>
#include <vector>
#include <fstream>
#include <iostream>
#include <pthread.h>

#include "ProtocolCommands.hpp"

#define MAX_MESSAGE_NUMBER 5 // Maximum number of messages stored in the shared memory
#define IPC_PATH_FILE "/tmp/key.txt"

#ifdef _SEM_SEMUN_UNDEFINED
union semun {
  int val;               // Value for SETVAL
  struct semid_ds *buf;  // Buffer for IPC_STAT, IPC_SET
  unsigned short *array; // Array for GETALL, SETALL
  struct seminfo *__buf; // Buffer for IPC_INFO
};
#endif

class IPC
{
private:
  pthread_mutex_t mMutex;
  static IPC *instance;         // Pointer to the singleton instance
  int semId;                    // Identifier to the semaphore array
  int shmMessagesId;            // Identifier to the shared memory where we store messages
  int shmClientsId;             // Identifier to the shared memory where we store the number of clients
  int shmCurrentIndexId;        // Identifier to the shared memory where we store the current index
  EncodedMessage *messageArray; // Address of the start of the array of stored messages
  int *numberClients;           // Address of the number of clients connected to the server
  int *currentIndex;            // Address of the index of where we will write the next message

  IPC(); // Private constructor

public:
  ~IPC();         // Destructor
  void destroy(); // Properly terminates all the IPC created

  static IPC *getInstance(); // Returns the singleton instance of IPC (creates it if needed)

  void addMessage(EncodedMessage message); // Adds a message to the shared memory
  void setNumberOfClients(int n);          // Sets the number of clients in the shared memory to n
  int getNumberOfClients();                // Gets the number of clients in the shared memory

  std::vector<EncodedMessage> getAllMessages();       // Returns all messages stored (from oldest to most recent)
  std::vector<EncodedMessage> getLastMessages(int n); // Returns the n most recent message stored
  EncodedMessage getLastMessage();                    // Returns the most recent message stored

  void operateOnSemaphore(int value); // Calls an operation on the semaphore array, adding "value" (will subtract if negative), or rdv if it is equal to 0
};

#endif
