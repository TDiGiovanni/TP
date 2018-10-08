#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <arpa/inet.h> // htons()
#include <netinet/in.h> // struct sockaddr_in
#include <unistd.h> // close()

int main (int argc, char** argv) {
  int n, sum=0; // Nombre de valeurs et somme des valeurs récupérées
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
  addrServ.sin_port= htons(0);
  socklen_t sizeServ= sizeof(addrServ);

  struct sockaddr* addrClient;
  socklen_t sizeClient= sizeof(addrClient);

  // Nommage de la socket
  if (bind(dSoc,(struct sockaddr*)&addrServ,sizeof(addrServ))) {
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

  // Affichage des infos de la socket (adresse IP et n° de port)
  char buf_addr[INET_ADDRSTRLEN];
  printf("Adresse IP : %s \n",inet_ntoa(addrServ.sin_addr));
  printf("N° de port : %i \n",ntohs(addrServ.sin_port));
  
  // Attente de requêtes d'un client
  while (1) {
    nbOctetsLus= recvfrom(dSoc,&n,sizeof(n),0,addrClient,&sizeClient);
    if (nbOctetsLus == -1) {
      perror("Erreur recvfrom ");
      close(dSoc);
      return 1;
    }

    // Vérification de la taille du message reçu
    if (nbOctetsLus != sizeof(n)) {
      fprintf(stderr,"Erreur dans la réception du message : pas assez d'octets reçus");
      close(dSoc);
      return 1;
    }
    
    // Récupération des infos de l'envoyeur
    inet_ntop(AF_INET,&((struct sockaddr_in*)addrClient)->sin_addr,buf_addr,INET_ADDRSTRLEN);

    // Affichage du message
    printf("Message reçu : %d, de (%s, %d) \n",n,buf_addr,ntohs(((struct sockaddr_in*)addrClient)->sin_port));
    sum+=n;
    printf("Somme jusqu'à présent : %d",sum);
  }

  // Fermeture de la socket
  if (close(dSoc) == -1) {
    perror("Erreur close ");
    return 1;
  }

  return 0;
}
