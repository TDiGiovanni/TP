#include "NetworkListener.hpp"

NetworkListener::NetworkListener(const unsigned int port) {

	m_listenSocket = socket(AF_INET, SOCK_STREAM, 0);
	if(m_listenSocket < 0) { throw std::runtime_error("Can't initialize connection (socket)."); }

  	struct sockaddr_in addr;

  	addr.sin_addr.s_addr = htonl(INADDR_ANY);

  	if(port == 0) { //Any port

		socklen_t socketAddressSize{sizeof(struct sockaddr_in)};
		if (getsockname(m_listenSocket, (struct sockaddr*)(&addr), &socketAddressSize) == -1) { throw std::runtime_error("Can't get socket informations."); }
		std::cout << "Using port " << ntohs(addr.sin_port) << std::endl;;
	}

   	else { addr.sin_port = htons(port); }

   	addr.sin_family = AF_INET;

   	if(bind(m_listenSocket, (sockaddr*) &addr, sizeof(struct sockaddr_in)) < 0) { throw std::runtime_error("Can't initialize connection (bind) (you may try with an other port)."); }
   	if(listen(m_listenSocket, MAX_WAITING_CLIENTS) < 0) { throw std::runtime_error("Can't initialize connection (listen)."); }

   	FD_SET(m_listenSocket, &m_fdSet);
   	FD_SET(0, &m_fdSet); //stdin
}

bool NetworkListener::newConnectionWaiting() {

	if(select(m_listenSocket+1, &m_fdSet, nullptr, nullptr, nullptr) < 0) { throw std::runtime_error("Error with select function."); }

	if(FD_ISSET(m_listenSocket, &m_fdSet)) { return true; }

	return false;
}

NetworkConnection NetworkListener::getNewConnection() {

	int newClient = accept(m_listenSocket, nullptr, 0);

	if(newClient < 0) { throw std::runtime_error("Can't create new connection from accept function."); }

	return NetworkConnection(newClient);
}