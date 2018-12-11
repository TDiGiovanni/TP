#include "ProtocolEncoder.hpp"

ProtocolEncoder::ProtocolEncoder(const std::string &userName):
	m_userName{userName} {

	if(m_userName.size() >= MAX_USERNAME_SIZE) { m_userName.erase(m_userName.begin() + MAX_USERNAME_SIZE, m_userName.end()); }
}

EncodedMessage ProtocolEncoder::encodeChatMessage(const std::string message) {

	std::string finalMessage{message};
	if(finalMessage.size() >= MAX_MESSAGE_SIZE) { finalMessage.erase(finalMessage.begin() + MAX_MESSAGE_SIZE, finalMessage.end()); }
	//If too long, cut it

	EncodedMessage newMessage;

	newMessage.type = Command::ChatMessage;

	time_t timestamp;
    time(&timestamp);
    struct tm *t{localtime(&timestamp)};

    newMessage.sendTime = Time{static_cast<uint16_t>(t->tm_year + 1900), static_cast<uint8_t>(t->tm_mon + 1), static_cast<uint8_t>(t->tm_mday), static_cast<uint8_t>(t->tm_hour), static_cast<uint8_t>(t->tm_min)};

    newMessage.userNameSize = static_cast<uint8_t>(m_userName.size());
    newMessage.messageSize = static_cast<uint16_t>(finalMessage.size());
    newMessage.userName = m_userName;
    newMessage.message = finalMessage;

	return newMessage;
}

std::string ProtocolEncoder::encodeForSend(EncodedMessage encodedMessage) {

	std::string finalMessage;

	finalMessage += static_cast<uint8_t>(encodedMessage.type);

	// Splitting sendTime in two : string only accept int8
	uint16_t splitSize{encodedMessage.sendTime.year};
	splitSize >>= 8;
	splitSize++;
	finalMessage += static_cast<uint8_t>(splitSize);

	splitSize = encodedMessage.sendTime.year << 8;
	splitSize >>= 8;
	finalMessage += static_cast<uint8_t>(splitSize);

	finalMessage += static_cast<uint8_t>(encodedMessage.sendTime.month);
	finalMessage += static_cast<uint8_t>(encodedMessage.sendTime.day);
	finalMessage += static_cast<uint8_t>(encodedMessage.sendTime.hour);
	finalMessage += static_cast<uint8_t>(encodedMessage.sendTime.minute);
	finalMessage += static_cast<uint8_t>(encodedMessage.userNameSize);

	splitSize = encodedMessage.messageSize;
	splitSize >>= 8;
	finalMessage += static_cast<uint8_t>(splitSize);

	splitSize = encodedMessage.messageSize << 8;
	splitSize >>= 8;
	finalMessage += static_cast<uint8_t>(splitSize);

	for(char currentChar: encodedMessage.userName) { finalMessage += currentChar; }
	for(char currentChar: encodedMessage.message) { finalMessage += currentChar; }

	return finalMessage;
}