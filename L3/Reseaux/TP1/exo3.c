#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <arpa/inet.h>

int main (int argc, char** argv) {
  if (argc<2 || argc>3) { // On veut soit 1 soit 2 arguments
    fprintf(stderr,"Erreur : mauvais nombre d'arguments. \n");
    return 1;
  }

  char* host= argv[1]; // Le premier argument est l'hôte.
  
  char* serv= NULL;
  if (argc==3)
    serv=argv[2]; // Le second argument est le serveur (optionnel).
  
  struct addrinfo* info;
  
  int err_addr= getaddrinfo(host,serv,NULL,&info);
  if (err_addr) { // Check si erreur dans l'appel
    fprintf(stderr,"Erreur dans la récupération de l'adresse : %s \n", gai_strerror(err_addr));
    return 1;
  }

  char buf_adr4[INET_ADDRSTRLEN]; // Buffer pour stocker l'adresse IPv4.
  char buf_adr6[INET6_ADDRSTRLEN]; // Buffer pour stocker l'adresse IPv6.
  char buf_host[NI_MAXHOST]; // Buffer pour stocker l'hôte.
  char buf_serv[NI_MAXSERV]; // Buffer pour stocker le serveur.
  
  while (info != NULL) {
    int err_nom= getnameinfo(info->ai_addr,info->ai_addrlen,buf_host,NI_MAXHOST,buf_serv,NI_MAXSERV,0);
    if (err_nom) { // Check si erreur dans l'appel
      fprintf(stderr,"Erreur dans la récupération du nom : %s \n", gai_strerror(err_nom));
      return 1;
    }
    
    printf("Nom cannonique : %s \n",buf_host);

    if (info->ai_family == AF_INET) { // Si IPv4
      struct in_addr adr= ((struct sockaddr_in*)info->ai_addr)->sin_addr; // Cast de la struct in_addr (récupérée avec getaddrinfo) vers une struct sockaddr_in
      inet_ntop(info->ai_family,&adr,buf_adr4,INET_ADDRSTRLEN); // Appel de inet_ntop pour transformer l'adresse IP en chaine de caractère pour l'afficher
      printf("Adresse IP : %s \n",buf_adr4);
    }
    else { // Si IPv6
      struct in6_addr adr= ((struct sockaddr_in6*)info->ai_addr)->sin6_addr; // Cast de la struct in_addr (récupérée avec getaddrinfo) vers une struct sockaddr_in6
      inet_ntop(info->ai_family,&adr,buf_adr6,INET6_ADDRSTRLEN); // Appel de inet_ntop pour transformer l'adresse IP en chaine de caractère pour l'afficher
      printf("Adresse IP : %s \n",buf_adr6);
    }
    
    printf("\n");
    info= info->ai_next; // On récupère le suivant.
  }

  freeaddrinfo(info); // Libération de la mémoire.
  
  return 0;
}
