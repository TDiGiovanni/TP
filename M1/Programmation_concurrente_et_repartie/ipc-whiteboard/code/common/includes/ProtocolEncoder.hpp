#ifndef PROTOCOLENCODER_HPP
#define PROTOCOLENCODER_HPP

#include <string>

#include "ProtocolCommands.hpp"

class ProtocolEncoder {

	public:

		ProtocolEncoder(const std::string &userName);

		ProtocolEncoder(const ProtocolEncoder &networkConnection) = delete;
		ProtocolEncoder &operator=(const ProtocolEncoder &networkConnection) = delete;

		EncodedMessage encodeChatMessage(const std::string message);
		std::string encodeForSend(EncodedMessage message);

	private:

		std::string m_userName;
};

#endif