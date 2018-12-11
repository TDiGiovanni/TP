#ifndef PROTOCOLCOMMANDS_HPP
#define PROTOCOLCOMMANDS_HPP

#include <string>
#include <ctime>

#define MAX_REQUEST_SIZE 	65536
#define MAX_MESSAGE_SIZE 	65526
#define MAX_USERNAME_SIZE	256
#define MIN_MESSAGE_SIZE	((unsigned int) 10)

//MAX_MESSAGE_SIZE = 65536 (2^16) - 1(type) - 6(time) - 1(usernameSize) - 2(messageSize)

enum Command {
	EmptyMessage = 0,
	ChatMessage = 1,
	GetOlderMessages = 2,
	Quit = 3
};

typedef struct {

	uint16_t year;
	uint8_t month, day, hour, minute;

} Time;

typedef struct {

	Command type;
	Time sendTime;
	uint8_t userNameSize;
	uint16_t messageSize;
	std::string userName, message;

} EncodedMessage;

#endif