#ifndef NETWORKLISTENER_HPP
#define NETWORKLISTENER_HPP

#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#include <string>
#include <stdexcept>
#include <iostream>

#include "NetworkConnection.hpp"

#define MAX_WAITING_CLIENTS 5

class NetworkListener {

	public:

		NetworkListener(const unsigned int port);

		NetworkListener(const NetworkListener &networkConnection) = delete;
		NetworkListener &operator=(const NetworkListener &networkConnection) = delete;


		bool newConnectionWaiting();
		//Return true if the entry is a new connection or false if it comes from stdin

		NetworkConnection getNewConnection();

	private:

		int m_listenSocket;
		fd_set m_fdSet;
};

#endif