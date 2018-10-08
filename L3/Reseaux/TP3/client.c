#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <arpa/inet.h> // htons()
#include <netinet/in.h> // struct sockaddr_in
#include <unistd.h> // close()
#include <netdb.h> // freeaddrinfo()

int main (int argc, char** argv) {
  char* sendMessage= argv[1]; // Message à envoyer
  char* recvMessage; // Message à recevoir
  char* adresse= argv[2]; // Adresse du serveur
  int numport= atoi(argv[3]); // N° de port du serveur
  
  struct addrinfo parametres;
  parametres.ai_family= AF_INET;
  parametres.ai_socktype= SOCK_STREAM;
  parametres.ai_protocol= 0;
  parametres.ai_flags= 0;

  struct addrinfo* addrServ;

  // Création de la socket
  int dSoc= socket(AF_INET,SOCK_STREAM,0);
  if (dSoc == -1) {
    perror("Erreur socket ");
    return 1;
  }

  // Transformation adresse
  if (getaddrinfo(adresse,NULL,&parametres,&addrServ) != 0) {
    perror("Erreur getaddrinfo ");
    close(dSoc);
    return 1;
  }
  struct sockaddr_in* serv= (struct sockaddr_in*)&(addrServ->ai_addr);
  serv->sin_family= AF_INET;
  inet_pton(AF_INET,adresse,&(serv->sin_addr));
  serv->sin_port= htons(numport);

  // Connection au serveur
  if (connect(dSoc,(struct sockaddr*)addrServ,sizeof(addrServ)) != 0) {
    perror("Erreur connect ");
      freeaddrinfo(addrServ);
      close(dSoc);
      return 1;
  };

  // Envoi et réception de requêtes avec le serveur
  while (1) {
    if (send(dSoc,&sendMessage,sizeof(sendMessage),0)== -1) {
      perror("Erreur send ");
      freeaddrinfo(addrServ);
      close(dSoc);
      return 1;
    }
    else printf("Message envoyé. \n");
    
    if (recv(dSoc,&recvMessage,sizeof(recvMessage),0) == -1) {
      perror("Erreur recv ");
      freeaddrinfo(addrServ);
      close(dSoc);
      return 1;
    }
    else printf("Message reçu : %s. \n",recvMessage);
  }

  // Libération de la mémoire
  freeaddrinfo(addrServ);

  // Fermeture de la socket
  if (close(dSoc) == -1) {
    perror("Erreur close ");
    return 1;
  }

  return 0;
}
