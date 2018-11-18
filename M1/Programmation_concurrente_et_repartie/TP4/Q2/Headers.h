#include <arpa/inet.h>      // inet_pton
#include <errno.h>
#include <netinet/in.h>     // struct sockaddr_in
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <time.h>
#include <unistd.h>

#define true 1
#define false 0
#define MAX_STRING_SIZE 256
#define MAX_CLIENTS 2

typedef int bool;

typedef struct message {
    char string[MAX_STRING_SIZE]; // Le message
    bool sendToOtherClient; // True si on veut l'envoyer aux autres clients connectés, false si on veut l'afficher sur le serveur
} message;

// Paramètres pour l'appel de la fonction "communicate"
typedef struct paramsCommunicate {
    int mySocketDescriptor;
    int *otherSocketDescriptors;
} paramsCommunicate;