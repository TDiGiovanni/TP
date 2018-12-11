#include "ClientManager.hpp"

ClientManager::ClientManager(NetworkListener* listener) {
	this->mNetworkListener = listener;
}

void ClientManager::loop() {
	std::cout << "== Starting ClientManager loop ==" << std::endl;
	bool loopContinues = true;
	IPC *ipc = IPC::getInstance();
	pid_t child_pid = 1;

	// "Endless" loop.
	while (loopContinues) {
		std::cout << "== Waiting for a new connection ==" << std::endl;

		if (mNetworkListener->newConnectionWaiting()) {
			// A client is attempting to connect.
			if (ipc->getNumberOfClients() >= MAX_CONNECTED_CLIENTS) {
				std::cout << "== Warning : client stack is full ==" << std::endl;
				// List is full
				// TODO : connect, send to the client the message full, disconnect

			} else {
				std::cout << "== A client is attempting to connect ==" << std::endl;
				NetworkConnection connectionToClient = mNetworkListener->getNewConnection();

				if ((child_pid = fork()) == -1) { // Error.
					throw std::runtime_error("Fork failed : returned -1.");

				} else if (child_pid == 0) { // In child.
					// Instanciating a new Client.
					Client client(connectionToClient);
					// Start client threads
					client.loop();
					loopContinues = false;

				} else { // In parent. (child_pid > 0)
					// Incrementing clients number.
					ipc->setNumberOfClients(ipc->getNumberOfClients() + 1);
				}
			}
		} else {
			// Keyboard input from terminal.
			// If input, quit server.
			std::cout << "== Keyboard input from terminal ==" << std::endl;
			loopContinues = false;
		}
	}

	// If we are in father process
	if (child_pid > 0) {
		// When exiting server
		ipc->destroy();
	}
}