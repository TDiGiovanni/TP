#include "Headers.h"

void *communicate(void *argParameters)
{
    paramsCommunicate *parameters = (paramsCommunicate *)argParameters;
    int mySocketDescriptor = parameters->mySocketDescriptor;
    int *otherSocketDescriptors = parameters->otherSocketDescriptors;

    message messageToReceive;

    while (true)
    {
        // Réception d'un message
        int messageLength = recv(mySocketDescriptor, &messageToReceive, sizeof(messageToReceive), 0);
        if (messageLength == -1)
        {
            perror("Receiving message");
            return (void *)-1;
        }
        if (messageLength == 0)
            break;

        if (messageToReceive.sendToOtherClient) // On veut l'envoyer aux autres clients
        {
            for (int i = 0; i < MAX_CLIENTS; i++)                    // Tous les clients
                if (otherSocketDescriptors[i] != mySocketDescriptor) // Sauf nous
                {
                    messageLength = send(otherSocketDescriptors[i], &messageToReceive, sizeof(messageToReceive), 0); // Envoi du message
                    if (messageLength == -1)
                    {
                        perror("Sending message");
                        return (void *)-1;
                    }
                    if (messageLength == 0)
                        break;
                }
            printf("Message reçu et envoyé aux autres clients \n");
        }
        else // On veut l'afficher sur le serveur
            printf("Message reçu du client %i : %s \n", mySocketDescriptor, messageToReceive.string);
    }

    // Fin de la communication
    printf("Connexion terminée \n");
    int error = close(mySocketDescriptor);
    if (error == -1)
    {
        perror("Closing socket");
        return (void *)-1;
    }

    return (void *)0;
}

int main(int argc, char **argv)
{
    srand(time(NULL));

    // Création de la socket
    int socketDescriptor = socket(AF_INET, SOCK_STREAM, 0);
    if (socketDescriptor == -1)
    {
        perror("Creating socket");
        return -1;
    }

    // Nommage de la socket
    struct sockaddr_in socketAddress;
    socketAddress.sin_family = AF_INET;         // Famille d'adresse IP (ici IPv4)
    socketAddress.sin_addr.s_addr = INADDR_ANY; // Adresse IP utilisée (ici any)
    socketAddress.sin_port = htons(0);          // Port utilisé (ici any)
    socklen_t socketAddressSize = sizeof(struct sockaddr_in);

    int socketName = bind(socketDescriptor, (struct sockaddr *)&socketAddress, socketAddressSize);
    if (socketName == -1)
    {
        perror("Binding socket");
        return -1;
    }

    // Récupération des infos de la socket (adresse IP et n° de port)
    int error = getsockname(socketDescriptor, (struct sockaddr *)&socketAddress, &socketAddressSize);
    if (error == -1)
    {
        perror("Getting socket infos");
        return -1;
    }

    // Affichage des infos (pour le client)
    char ipAdress[INET_ADDRSTRLEN];
    printf("Adresse IP : %s \n", inet_ntop(AF_INET, &(socketAddress.sin_addr.s_addr), ipAdress, INET_ADDRSTRLEN));
    printf("Numéro de port : %i \n", ntohs(socketAddress.sin_port));

    // Passage en mode écoute
    error = listen(socketDescriptor, 10); // Max 10 clients en attente
    if (error == -1)
    {
        perror("Socket listen");
        return -1;
    }

    // On accepte les clients qui se connectent au serveur
    int clientNumber = 0;
    struct sockaddr_in destAdress[MAX_CLIENTS];
    socklen_t destAdressSize = sizeof(struct sockaddr_in);
    int clientSockets[MAX_CLIENTS];

    pthread_t idThreads[MAX_CLIENTS];
    paramsCommunicate parameters[MAX_CLIENTS];

    while (clientNumber < MAX_CLIENTS)
    {
        clientSockets[clientNumber] = accept(socketDescriptor, (struct sockaddr *)&destAdress[clientNumber], &destAdressSize);
        if (clientSockets[clientNumber] == -1)
        {
            perror("Accepting connection");
            return -1;
        }

        parameters[clientNumber].mySocketDescriptor = clientSockets[clientNumber];
        parameters[clientNumber].otherSocketDescriptors = clientSockets;

        clientNumber++;

        printf("\nNouveau client connecté ! Encore %i clients... \n", (MAX_CLIENTS - clientNumber));
    }

    for (int i = 0; i < MAX_CLIENTS; i++)
        pthread_create(&idThreads[i], NULL, communicate, &parameters[i]);

    printf("\nTous les clients sont connectés. Début de la conversation... \n");

    for (int i = 0; i < MAX_CLIENTS; i++)
        pthread_join(idThreads[i], NULL);

    printf("Tous les clients sont déconnectés. Fermeture du serveur \n");

    // Fermeture de la socket
    error = close(socketDescriptor);
    if (error == -1)
    {
        perror("Closing socket");
        return -1;
    }

    return 0;
}