#ifndef NETWORKCONNECTION_HPP
#define NETWORKCONNECTION_HPP

#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <sys/select.h>

#include <string>
#include <stdexcept>
#include <iostream>

#include "ProtocolCommands.hpp"

class NetworkConnection {

	public:

		NetworkConnection();
		NetworkConnection(const int socket);
		NetworkConnection(const NetworkConnection &networkConnection);				//Transfert the ownership of the connection
		NetworkConnection &operator=(const NetworkConnection &networkConnection);	//Transfert the ownership of the connection

		bool connect(const std::string address, const unsigned int port) const;
		void disconnect() const;

		std::string receive() const;
		void send(const std::string message) const;

		void addToFd(fd_set &fdSet) const;
		void deleteFromFd(fd_set &fdSet) const;
		bool dataAreWaiting(fd_set &fdSet) const;

		unsigned int getHighestDescriptor(const unsigned int fdNumber);

	private:

		int m_connectionSocket;
};

#endif