#include "Headers.h"

int main(int argc, char **argv)
{
    srand(time(NULL));

    char ipAdress[MAX_STRING_SIZE];
    int portNumber;
    if (argc == 3) // Récupération des infos du serveur, si elles ont été renseignées
    {
        int i = 0;
        while (i < MAX_STRING_SIZE && argv[1][i] != '\0')
        {
            ipAdress[i] = argv[1][i];
            i++;
        }
        portNumber = atoi(argv[2]);

        printf("Les infos du serveur ont bien été récupérées \n");
    }
    else
    {
        char tempPortNumber[MAX_STRING_SIZE];
        printf("Les informations du serveur n'ont pas été renseignées correctement \n");

        printf("Entrez l'adresse IP de la socket du serveur : ");
        scanf("%s", ipAdress);

        printf("Entrez le numéro de port de la socket du serveur : ");
        scanf("%s", tempPortNumber);
        portNumber = atoi(tempPortNumber);
    }

    // Création de la socket
    int socketDescriptor = socket(AF_INET, SOCK_STREAM, 0);
    if (socketDescriptor == -1)
    {
        perror("Creating socket");
        return -1;
    }

    // Infos de la socket du serveur
    struct sockaddr_in destAdress;
    destAdress.sin_family = AF_INET;
    inet_pton(AF_INET, ipAdress, &(destAdress.sin_addr));
    destAdress.sin_port = htons(portNumber);
    socklen_t destAdressSize = sizeof(struct sockaddr_in);

    // Connexion au serveur
    int error = connect(socketDescriptor, (struct sockaddr *)&destAdress, destAdressSize);
    if (error == -1)
    {
        perror("Connecting to server");
        return -1;
    }

    printf("\nConnecté au serveur ! \n");
    
    printf("Attente du bon nombre de clients... \n");
    int remainingClients;
    do
    {
        int messageLength = recv(socketDescriptor, &remainingClients, sizeof(remainingClients), 0);
        if (messageLength == -1)
        {
            perror("Receiving message");
            return -1;
        }
    } while (remainingClients != MAX_CLIENTS);

    printf("Tous les clients sont connectés ! \n");

    // Boucle infinie d'envois et réceptions de messages
    message messageToSend;
    message messageToReceive;
    while (true)
    {
        printf("\nEcrivez le message à envoyer : \n");
        scanf("%s", messageToSend.string);

        printf("\nSouhaitez-vous envoyer le message : \n");
        printf("0 - au serveur \n");
        printf("1 - aux autres clients \n");
        scanf("%i", &(messageToSend.sendToOtherClient));

        // Envoi de message
        int messageLength = send(socketDescriptor, &messageToSend, MAX_STRING_SIZE, 0);
        if (messageLength == -1)
        {
            perror("Sending message");
            return -1;
        }

        printf("Message envoyé \n");

        memset(messageToSend.string, '\0', MAX_STRING_SIZE); // Reset du buffer

        // Réception de message
        messageLength = recv(socketDescriptor, &messageToReceive, MAX_STRING_SIZE, 0);
        if (messageLength == -1)
        {
            perror("Receiving message");
            return -1;
        }

        printf("Message reçu : %s \n", messageToReceive.string);

        memset(messageToReceive.string, '\0', MAX_STRING_SIZE); // Reset du buffer
    }

    // Fermeture de la socket
    error = close(socketDescriptor);
    if (error == -1)
    {
        perror("Closing socket");
        return -1;
    }

    return 0;
}