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
  char sendMessage[INET_ADDRSTRLEN]; // Message à envoyer
  int sizeMessage = 500;
  char recvMessage[sizeMessage]; // Message à recevoir
  size_t nbOctetsLus;

  // Création de la socket
  int dSocServ= socket(AF_INET,SOCK_STREAM,0);
  if (dSocServ == -1) {
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
  if (bind(dSocServ,(struct sockaddr*)&addrServ,sizeServ)) {
      perror("Erreur bind ");
      close(dSocServ);
      return 1;
    }

  // Récupération des infos de la socket (adresse IP et n° de port)
  if (getsockname(dSocServ,(struct sockaddr*)&addrServ,&sizeServ) == -1) {
      perror("Erreur getsockname ");
      close(dSocServ);
      return 1;
    }

  printf("Adresse IP : %s \n",inet_ntoa(addrServ.sin_addr));
  printf("N° de port : %i \n",ntohs(addrServ.sin_port));
  
  printf("Attente de requête d'un client \n");
  listen(dSocServ,1);
  while (1) {
    int dSocClient= accept(dSocServ,&addrClient,&sizeClient);
    
    nbOctetsLus= recv(dSocClient,&recvMessage,sizeMessage,0);
    if (nbOctetsLus == -1) {
      perror("Erreur recvfrom ");
      close(dSocClient);
      close(dSocServ);
      return 1;
    }

    // Vérification de la taille du message reçu
    if (nbOctetsLus > sizeMessage) {
      fprintf(stderr,"Erreur dans la réception du message.");
      close(dSocClient);
      close(dSocServ);
      return 1;
    }

    printf("\nMessage reçu : %s \n\n",recvMessage);

    struct addrinfo* infos;
    int err_addr= getaddrinfo(recvMessage,NULL,NULL,&infos);
    if (err_addr) {
      perror("Erreur getaddrinfo ");;
      return 1;
    }

    char buf_adr[INET_ADDRSTRLEN]; // Buffer pour stocker l'adresse IPv4.
      
    struct in_addr adr= ((struct sockaddr_in*)infos->ai_addr)->sin_addr; // Cast de la struct in_addr (récupérée avec getaddrinfo) vers une struct sockaddr_in
    inet_ntop(infos->ai_family,&adr,sendMessage,INET_ADDRSTRLEN); // Appel de inet_ntop pour transformer l'adresse IP en chaine de caractère pour l'afficher
    printf("Adresse IP : %s \n",sendMessage);
    
    printf("Envoi d'un message au client \n");
    sendMessage = strcat("Bonjour ",recvMessage);
    if (send(dSocClient,&sendMessage,sizeof(sendMessage),0) == -1) {
      perror("Erreur sendto ");
      close(dSocClient);
      close(dSocServ);
      return 1;
    }
    else printf("Message envoyé \n");
    
    // Fermeture de la socket
    if (close(dSocClient) == -1) {
      perror("Erreur close ");
      close(dSocServ);
      return 1;
    }
  }

  // Fermeture de la socket
  if (close(dSocServ) == -1) {
    perror("Erreur close ");
    return 1;
  }

  return 0;
}
