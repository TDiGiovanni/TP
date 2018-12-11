#include "NetworkConnection.hpp"

NetworkConnection::NetworkConnection():
	m_connectionSocket{0} {

	m_connectionSocket = socket(AF_INET, SOCK_STREAM, 0);

    if(m_connectionSocket < 0) { throw std::runtime_error("Can't create a new socket."); }
}

NetworkConnection::NetworkConnection(const int socket):
	m_connectionSocket{std::move(socket)} {}

NetworkConnection::NetworkConnection(const NetworkConnection &networkConnection):
	m_connectionSocket{std::move(networkConnection.m_connectionSocket)} {}

NetworkConnection &NetworkConnection::operator=(const NetworkConnection &networkConnection) {

	m_connectionSocket = std::move(networkConnection.m_connectionSocket);

	return *this;
}

bool NetworkConnection::connect(const std::string address, const unsigned int port) const {

	//A refaire, en rendant non bloquant et respectant le timeout

	struct sockaddr_in addr;

    addr.sin_port = htons(port);
    addr.sin_family = AF_INET;

    if(inet_aton(&address[0], &addr.sin_addr) == 0) { return false; }

    if(::connect(m_connectionSocket, (sockaddr*)(&addr), sizeof(struct sockaddr_in)) < 0) { return false; }

    return true;
}

void NetworkConnection::disconnect() const {}

std::string NetworkConnection::receive() const {

	std::string message;
	message.resize(MAX_MESSAGE_SIZE);

	long int nbCharRead{::recv(m_connectionSocket, &message[0], MAX_MESSAGE_SIZE, 0)};

	if(nbCharRead < 0) { throw std::runtime_error("Error with message reading."); }
	//else if(nbCharRead == 0) {} //Disconnected ?
	else if(nbCharRead < MAX_MESSAGE_SIZE) { message.erase(nbCharRead, MAX_MESSAGE_SIZE-nbCharRead-1); }

	return message;
}

void NetworkConnection::send(const std::string message) const {

	long int nbCharSend{::send(m_connectionSocket, &message[0], message.size(), 0)};

	if(nbCharSend < 0 || nbCharSend < static_cast<int>(message.size())) { throw std::runtime_error("Error with message sending."); }
	//else if(nbCharRead == 0) {} //Disconnected ?
}

void NetworkConnection::addToFd(fd_set &fdSet) const { FD_SET(m_connectionSocket, &fdSet); }
void NetworkConnection::deleteFromFd(fd_set &fdSet) const { FD_CLR(m_connectionSocket, &fdSet); }

bool NetworkConnection::dataAreWaiting(fd_set &fdSet) const {

	if(FD_ISSET(m_connectionSocket, &fdSet)) { return true; }
	return false;
}

unsigned int NetworkConnection::getHighestDescriptor(const unsigned int fdNumber) {

	if(static_cast<int>(fdNumber) > m_connectionSocket) { return fdNumber; }
	return m_connectionSocket;
}
