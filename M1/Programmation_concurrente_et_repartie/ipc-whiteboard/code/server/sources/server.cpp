#include <iostream>
#include <string>
#include <sstream>
#include "IPC.hpp"
#include "ClientManager.hpp"

unsigned int requestPort() {
	std::string serverPort;
	std::cout << "Please enter server port: ";
	std::cin >> serverPort;
	unsigned int convertedPort{0};
	std::istringstream(serverPort) >> convertedPort;
	return convertedPort;
}

int main() {
	std::cout << "== Starting server ==" << std::endl;
	// Configuring NetworkListener
	NetworkListener networkListener(requestPort());
	// Getting ClientManager
	ClientManager manager(&networkListener);
	// Let's start the loop !
	manager.loop();
	return 0;
}