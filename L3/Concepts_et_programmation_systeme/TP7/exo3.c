#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

void signalAlarme(int sig) {
  static int cpt=5;

  switch (cpt) {
  case 5:
    printf("Bouge, tu as 5 secondes \n");
    cpt=3;
    alarm(5);
    break;

  case 3:
    printf("Bouge, tu as 3 secondes \n");
    cpt=0;
    alarm(3);
    break;
    
  default:
    printf("Trop tard \n");
    exit(0);
  }
}

int main(int argc, char** argv) {
  struct sigaction signal;
  signal.sa_handler= signalAlarme;
  signal.sa_flags=SA_RESTART;
  sigaction(SIGALRM,&signal,NULL);

  int a;
  printf("Entrez un nombre en moins de 10 secondes : \n");
  alarm(10);
  scanf("%d",&a);

  return 0;
}
