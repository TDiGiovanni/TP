#include <arpa/inet.h> // inet_pton
#include <errno.h>
#include <netinet/in.h> // struct sockaddr_in
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <time.h>
#include <unistd.h>

struct message
{
    int firstInt, secondInt;
    char *string;
} typedef message;