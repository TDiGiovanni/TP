#ifndef CLIENTMANAGER_HPP
#define CLIENTMANAGER_HPP

#include <vector>
#include <iostream>
#include <sys/types.h> // fork
#include <unistd.h> // fork

#include "NetworkConnection.hpp"
#include "NetworkListener.hpp"
#include "Client.hpp"

#define MAX_CONNECTED_CLIENTS 2

class ClientManager {
	public:
		ClientManager(NetworkListener* listener);
		void loop();
	private:
		NetworkListener* mNetworkListener;
		std::vector<pid_t> mClientPIDList; // Vector with all fork children's PID
};

#endif
