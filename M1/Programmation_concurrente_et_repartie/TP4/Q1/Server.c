#include "Headers.h"

int main(int argc, char **argv)
{
    srand(time(NULL));

    // Création de la socket
    int socketDescriptor = socket(AF_INET, SOCK_DGRAM, 0);
    if (socketDescriptor == -1)
    {
        perror("Creating socket");
        return 1;
    }

    // Nommage de la socket
    struct sockaddr_in socketAdress;
    socketAdress.sin_family = AF_INET;         // Famille d'adresse IP (ici IPv4)
    socketAdress.sin_addr.s_addr = INADDR_ANY; // Adresse IP utilisée (ici any)
    socketAdress.sin_port = htons(0);          // Port utilisé (ici any)
    socklen_t socketAdressSize = sizeof(struct sockaddr_in);

    int socketName = bind(socketDescriptor, (struct sockaddr *)&socketAdress, sizeof(socketAdress));
    if (socketName == -1)
    {
        perror("Binding socket");
        return 1;
    }

    // Récupération des infos de la socket (adresse IP et n° de port)
    int error = getsockname(socketDescriptor, (struct sockaddr *)&socketAdress, &socketAdressSize);
    if (error == -1)
    {
        perror("Getting socket infos");
        return 1;
    }

    // Affichage des infos pour le client
    char ipAdress[INET_ADDRSTRLEN];
    printf("Adresse IP : %s \n", inet_ntop(AF_INET, &(socketAdress.sin_addr), ipAdress, INET_ADDRSTRLEN));
    printf("Numéro de port : %i \n", ntohs(socketAdress.sin_port));

    // Infos de la socket recevante
    struct sockaddr_in destAdress;
    socklen_t destAdressSize = sizeof(struct sockaddr_in);

    printf("Attente du message... \n");

    // Réception du message
    char *messageToReceive;
    int messageLength = recvfrom(socketDescriptor, messageToReceive, sizeof(messageToReceive), 0, (struct sockaddr *)&destAdress, &destAdressSize);
    if (messageLength == -1)
    {
        perror("Receiving message");
        return 1;
    }

    // Affichage du message reçu et des infos de l'envoyeur
    printf("Message reçu : %s \n", messageToReceive);
    printf("Infos de l'envoyeur \n");
    printf("Adresse IP : %s \n", inet_ntop(AF_INET, &(destAdress.sin_addr), ipAdress, INET_ADDRSTRLEN));
    printf("Numéro de port : %i \n", ntohs(destAdress.sin_port));

    // Création du message à envoyer
    message messageToSend;
    printf("Entrez un premier entier : ");
    scanf("%i", &(messageToSend.firstInt));
    printf("Entrez un second entier : ");
    scanf("%i", &(messageToSend.secondInt));
    printf("Entrez une chaîne de caractères : ");
    scanf("%s", &(messageToSend.string));

    // Envoi du message
    messageLength = sendto(socketDescriptor, &messageToSend, sizeof(messageToSend), 0, (struct sockaddr *)&destAdress, destAdressSize);
    if (messageLength == -1)
    {
        perror("Sending message");
        return 1;
    }

    printf("Message envoyé \n");

    // Fermeture de la socket
    error = close(socketDescriptor);
    if (error == -1)
    {
        perror("Closing socket");
        return 1;
    }

    return 0;
}