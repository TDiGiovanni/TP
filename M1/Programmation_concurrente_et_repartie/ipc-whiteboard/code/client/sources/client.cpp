#include <iostream>
#include <string>
#include <sstream>
#include <sys/select.h>
#include <pthread.h>

#include "ProtocolEncoder.hpp"
#include "ProtocolDecoder.hpp"
#include "NetworkConnection.hpp"

struct ThreadParameters{

	NetworkConnection *connection;
	fd_set *fd;
	bool *haveToStop;
	ProtocolDecoder *decoder;
};


// Return the highest file descriptor for select and reset the file descriptor.
unsigned int resetFD(fd_set &set, NetworkConnection &connection) {

	unsigned int fdNumber{0};
	connection.addToFd(set);
	FD_SET(0, &set); // Stdin
	return connection.getHighestDescriptor(fdNumber);
}

void* drawMessagesThread(void* args) {

	ThreadParameters *parameters = static_cast<ThreadParameters*>(args);
	EncodedMessage encodedMessage;

	while(!(*(parameters->haveToStop))) {

		encodedMessage = parameters->decoder->decodeFromReceive(parameters->connection->receive());
		switch (encodedMessage.type) {

			case Command::ChatMessage:
				std::cout << parameters->decoder->decodeForChat(encodedMessage) << std::endl;
				break;
			case Command::Quit:
				*(parameters->haveToStop) = true;
				break;
			default:
				break;
		}
	}

	pthread_exit(nullptr);
}

void communicate(NetworkConnection &connection) {
	// Getting user name from keyboard.
	std::string userName;
	std::cout << "Enter user name: ";
	std::cin >> userName;

	// Defining used variables.
	ProtocolEncoder encoder{userName};
	ProtocolDecoder decoder;
	fd_set communicationSet;
	bool wantToQuit{false};
	std::string userInput, messageToSend;

	ThreadParameters parameters{&connection, &communicationSet, &wantToQuit, &decoder};

	pthread_t threadID;
	int threadNumber = pthread_create(&threadID, NULL, drawMessagesThread , ((void*) &parameters));

	if(threadNumber != 0)
		wantToQuit = true; //Error

	// While client is connected to server.
	while (!wantToQuit) {

		std::getline(std::cin, userInput);

		// Send the message to the server.
		if(userInput == "Quit") {

			EncodedMessage quitMessage{encoder.encodeChatMessage("")};
			quitMessage.type = Command::Quit;
			connection.send(encoder.encodeForSend(quitMessage));
			wantToQuit = true;
		} else if(userInput != "") {

			messageToSend = encoder.encodeForSend(encoder.encodeChatMessage(userInput));
			connection.send(messageToSend);
		}
	}

	if(threadNumber == 0)
		pthread_join(threadID, NULL);
}

int main(void) {

	std::string serverIP, serverPort;

	// Getting IP and PORT from user keyboard.
	std::cout << "Welcome to our web chat!" << std::endl;
	std::cout << "Enter server IP: ";
	std::cin >> serverIP;
	std::cout << "Enter server port: ";
	std::cin >> serverPort;

	unsigned int convertedPort{0};
	std::istringstream(serverPort) >> convertedPort;

	NetworkConnection connection;

	// Attempting connection to IP:PORT.
	if (connection.connect(serverIP, convertedPort)) {
		// Connection success.
		std::cout << "Connected !" << std::endl;
		communicate(connection);
	} else {
		// Connection failed.
		std::cout << "Can't connect to " << serverIP << ":" << serverPort << "." << std::endl;
	}

	std::cout<< "Bye!" << std::endl;

	return 0;
}