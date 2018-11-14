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
    int socketDescriptor = socket(AF_INET, SOCK_DGRAM, 0);
    if (socketDescriptor == -1)
    {
        perror("Creating socket");
        return 1;
    }

    // Infos de la socket du serveur
    struct sockaddr_in destAdress;
    destAdress.sin_family = AF_INET;
    inet_pton(AF_INET, ipAdress, &(destAdress.sin_addr));
    destAdress.sin_port = htons(portNumber);
    socklen_t destAdressSize = sizeof(struct sockaddr_in);

    // Envoi du message
    char messageToSend[MAX_STRING_SIZE];
    printf("\nEcrivez le message à envoyer : \n");
    scanf("%s", messageToSend);

    int messageLength = sendto(socketDescriptor, messageToSend, sizeof(messageToSend), 0, (struct sockaddr *)&destAdress, destAdressSize);
    if (messageLength == -1)
    {
        perror("Sending message");
        return 1;
    }

    printf("Message envoyé. Attente du retour du serveur... \n");

    // Réception du message
    message messageToReceive;

    messageLength = recvfrom(socketDescriptor, &messageToReceive, sizeof(messageToReceive), 0, (struct sockaddr *)&destAdress, &destAdressSize);
    if (messageLength == -1)
    {
        perror("Receiving message");
        return 1;
    }

    // Affichage du message reçu
    printf("Message reçu \n");
    printf("Premier entier : %i \n", messageToReceive.firstInt);
    printf("Second entier : %i \n", messageToReceive.secondInt);
    printf("Chaîne de caractères : %s \n", messageToReceive.string);

    // Fermeture de la socket
    int error = close(socketDescriptor);
    if (error == -1)
    {
        perror("Closing socket");
        return 1;
    }

    return 0;
}