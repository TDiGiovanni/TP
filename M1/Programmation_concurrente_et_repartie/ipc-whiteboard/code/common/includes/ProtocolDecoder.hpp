#ifndef PROTOCOLDECODER_HPP
#define PROTOCOLDECODER_HPP

#include <string>
#include <stdexcept>

#include "ProtocolCommands.hpp"

class ProtocolDecoder {

	public:

		ProtocolDecoder();

		ProtocolDecoder(const ProtocolDecoder &networkConnection) = delete;
		ProtocolDecoder &operator=(const ProtocolDecoder &networkConnection) = delete;

		EncodedMessage decodeFromReceive(const std::string message);
		std::string decodeForChat(EncodedMessage message);

	private:

		const std::string m_userName;
};

#endif