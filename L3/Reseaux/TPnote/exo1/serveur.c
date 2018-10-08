#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <arpa/inet.h> // htons()
#include <netinet/in.h> // struct sockaddr_in
#include <unistd.h> // close()
#include <string.h>

int main (int argc, char** argv) {
  char* sendMessage; // Message à envoyer
  int sizeMessage = 500;
  char recvMessage[sizeMessage]; // Message à recevoir
  size_t nbOctetsLus;

  // Création de la socket
  int dSoc= socket(AF_INET,SOCK_DGRAM,0);
  if (dSoc == -1) {
    perror("Erreur socket ");
    return 1;
  }

  struct sockaddr_in addrServ;
  addrServ.sin_family= AF_INET;
  addrServ.sin_addr.s_addr= INADDR_ANY;
  addrServ.sin_port= htons(atoi(argv[1]));
  socklen_t sizeServ= sizeof(addrServ);

  struct sockaddr_in addrClient;
  socklen_t sizeClient= sizeof(addrClient);

  // Nommage de la socket;
  if (bind(dSoc,(struct sockaddr*)&addrServ,sizeServ)) {
      perror("Erreur bind ");
      close(dSoc);
      return 1;
    }

  // Récupération des infos de la socket (adresse IP et n° de port)
  if (getsockname(dSoc,(struct sockaddr*)&addrServ,&sizeServ) == -1) {
      perror("Erreur getsockname ");
      close(dSoc);
      return 1;
    }

  printf("Adresse IP : %s \n",inet_ntoa(addrServ.sin_addr));
  printf("N° de port : %i \n",ntohs(addrServ.sin_port));
  
  printf("Attente de requête d'un client \n");
  while (1) {
    nbOctetsLus= recvfrom(dSoc,&recvMessage,sizeMessage,0,(struct sockaddr*)&addrClient,&sizeClient);
    if (nbOctetsLus == -1) {
      perror("Erreur recvfrom ");
      close(dSoc);
      return 1;
    }

    // Vérification de la taille du message reçu
    if (nbOctetsLus > sizeMessage) {
      fprintf(stderr,"Erreur dans la réception du message.");
      close(dSoc);
      return 1;
    }

    printf("\nMessage reçu : %s \n\n",recvMessage);

    printf("Envoi d'un message au client \n");
    sendMessage = strcat("Bonjour ",recvMessage);
    if (sendto(dSoc,&sendMessage,sizeof(sendMessage),0,(struct sockaddr*)&addrClient,sizeClient) == -1) {
      perror("Erreur sendto ");
      close(dSoc);
      return 1;
    }
    else printf("Message envoyé \n");
    
    // Fermeture de la socket
    if (close(dSoc) == -1) {
      perror("Erreur close ");
      return 1;
    }
  }

  // Fermeture de la socket
  if (close(dSoc) == -1) {
    perror("Erreur close ");
    return 1;
  }

  return 0;
}
