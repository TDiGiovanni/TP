#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

void signalRecu(int sig) {
  printf("Vous avez reçu le signal %d \n",sig);
  printf("Je ne termine pas ! \n");
}

int main(int argc, char** argv) {
  struct sigaction signal;
  signal.sa_handler= signalRecu; // SIG_IGN à la place de signalRecu pour ignorer le signal
  sigaction(SIGINT,&signal,NULL);

  while (1);

  return 0;
}
