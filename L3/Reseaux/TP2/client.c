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
  int n= atoi(argv[1]); // Valeur à envoyer
  char* adresse= argv[2]; // Adresse du serveur
  int numport= atoi(argv[3]); // N° de port du serveur
  
  struct addrinfo parametres;
  parametres.ai_family= AF_INET;
  parametres.ai_protocol= 0;
  parametres.ai_socktype= SOCK_DGRAM;
  parametres.ai_flags= 0;

  struct addrinfo* addrServ;

  // Création de la socket
  int dSoc= socket(AF_INET,SOCK_DGRAM,0);
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

  // Récupération des infos du serveur
  struct sockaddr_in* serv= (struct sockaddr_in*)&(addrServ->ai_addr);
  serv->sin_family= AF_INET;
  inet_pton(AF_INET,adresse,&(serv->sin_addr));
  serv->sin_port= htons(numport);

  // Envoi de n requêtes vers le serveur
  for (int i=0; i<=n; i++) {
    if (sendto(dSoc,&i,sizeof(i),0,(struct sockaddr*)addrServ,sizeof(addrServ)) == -1) {
      perror("Erreur sendto ");
      freeaddrinfo(addrServ);
      close(dSoc);
      return 1;
    }
    else printf("Message envoyé. \n");
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
