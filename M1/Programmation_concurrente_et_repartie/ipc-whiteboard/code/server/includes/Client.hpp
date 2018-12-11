#ifndef CLIENT_HPP
#define CLIENT_HPP

#include "ProtocolCommands.hpp" // import EncodedMessage, Time
#include "NetworkConnection.hpp"
#include "ProtocolDecoder.hpp"
#include "ProtocolEncoder.hpp"
#include "IPC.hpp"
#include <pthread.h>
#include <string>

#define UNDEFINED_NAME ""

class Client
{
public:
	Client(NetworkConnection &connection);
	~Client();

	static void *pushingThread(void *context);
	static void *pullingThread(void *context);
	void loop();

	void setClientIsWorking(bool b);

private:
	pthread_mutex_t mMutex;
	bool mClientIsWorking;
	bool mIsFirstMessage;
	NetworkConnection mNetworkConnection;
	std::string mUserName;
	ProtocolEncoder *mEncoder;
	ProtocolDecoder *mDecoder;
	IPC *mIPC;

	void pushToClient();
	void pullFromClient(EncodedMessage msg);
};

#endif
