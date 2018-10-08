#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <arpa/inet.h> // htons()
#include <netinet/in.h> // struct sockaddr_in
#include <unistd.h> // close()

int main (int argc, char** argv) {
  char* sendMessage; // Message à envoyer
  char* recvMessage; // Message à recevoir
  size_t nbOctetsLus;
  char buf_addr[INET_ADDRSTRLEN];

  // Création de la socket
  int dSocServ= socket(AF_INET,SOCK_STREAM,0);
  if (dSocServ == -1) {
    perror("Erreur socket ");
    return 1;
  }

  struct sockaddr_in addrServ;
  addrServ.sin_family= AF_INET;
  addrServ.sin_addr.s_addr= INADDR_ANY;
  addrServ.sin_port= htons(0);
  socklen_t sizeServ= sizeof(addrServ);

  struct sockaddr_in addrClient;
  socklen_t sizeClient= sizeof(addrClient);

  // Nommage de la socket
  if (bind(dSocServ,(struct sockaddr*)&addrServ,sizeof(addrServ))) {
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

  // Affichage des infos de la socket (adresse IP et n° de port)
  printf("Adresse IP : %s \n",inet_ntoa(addrServ.sin_addr));
  printf("N° de port : %i \n",ntohs(addrServ.sin_port));
  
  // Attente de requêtes d'un client
  listen(dSocServ,10);
  while (1) {
    int dSocClient= accept(dSoc,&addrClient,&sizeClient);
    
    nbOctetsLus= recv(dSocClient,&recvMessage,sizeof(recvMessage),0);
    if (nbOctetsLus == -1) {
      perror("Erreur recv ");
      close(dSocClient);
      close(dSocServ);
      return 1;
    }

    // Vérification de la taille du message reçu
    if (nbOctetsLus != sizeof(n)) {
      fprintf(stderr,"Erreur dans la réception du message : pas assez d'octets reçus");
      close(dSocClient);
      close(dSocServ);
      return 1;
    }
    
    // Récupération des infos de l'envoyeur
    inet_ntop(AF_INET,addrClient->sin_addr.s_addr,buf_addr,INET_ADDRSTRLEN);

    // Affichage du message
    printf("Message reçu : %d, de (%s, %d) \n",recvMessage,buf_addr,ntohs(((struct sockaddr_in*)&addrClient)->sin_port));

    // Fermeture de la socket
    if (close(dSocClient) == -1) {
      perror("Erreur close ");
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
