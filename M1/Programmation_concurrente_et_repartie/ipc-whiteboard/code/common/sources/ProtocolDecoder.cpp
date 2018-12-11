#include "ProtocolDecoder.hpp"
#include <iostream>

ProtocolDecoder::ProtocolDecoder() {}

EncodedMessage ProtocolDecoder::decodeFromReceive(const std::string message) {

	EncodedMessage newMessage;

	if(message.size() < MIN_MESSAGE_SIZE) { throw std::runtime_error("Decoder error: invalid size of message (" + std::to_string(message.size()) + "), expected at least " + std::to_string(MIN_MESSAGE_SIZE)); }

	newMessage.type = static_cast<Command>(message[0]);

	uint16_t splitedSize{static_cast<uint16_t>(message[1])};

	splitedSize <<= 8;
	splitedSize += static_cast<uint16_t>(message[2]);

	newMessage.sendTime = Time{splitedSize, static_cast<uint8_t>(message[3]), static_cast<uint8_t>(message[4]), static_cast<uint8_t>(message[5]), static_cast<uint8_t>(message[6])};

	newMessage.userNameSize = static_cast<uint8_t>(message[7]);

	splitedSize = static_cast<uint16_t>(message[8]);
	splitedSize <<= 8;
	splitedSize += static_cast<uint16_t>(message[9]);
	newMessage.messageSize = splitedSize;

	for(unsigned int i{MIN_MESSAGE_SIZE}; (i - MIN_MESSAGE_SIZE) < newMessage.userNameSize && i < message.size(); i++) { newMessage.userName += message[i]; }
	for(unsigned int i{MIN_MESSAGE_SIZE + newMessage.userNameSize}; (i - MIN_MESSAGE_SIZE - newMessage.userNameSize) < newMessage.messageSize && i < message.size(); i++) { newMessage.message += message[i]; }

	return newMessage;
}

std::string ProtocolDecoder::decodeForChat(EncodedMessage encodedMessage) {

	std::string result;

	if(encodedMessage.type == Command::ChatMessage) {

		result += '[';
		result += std::to_string(encodedMessage.sendTime.day);
		result += '/';
		result += std::to_string(encodedMessage.sendTime.month);
		result += '/';
		result += std::to_string(encodedMessage.sendTime.year);
		result += ", ";
		result += std::to_string(encodedMessage.sendTime.hour);
		result += ':';
		result += std::to_string(encodedMessage.sendTime.minute);
		result += "] ";
		result += encodedMessage.userName;
		result += ": ";
		result += encodedMessage.message;
	}

	return result;
}