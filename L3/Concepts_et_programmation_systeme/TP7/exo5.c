#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <string.h>

void signalSegFaultRecu(int sig) {
  printf("%s",strerror(errno));
}

int main(int argc, char** argv) {
  struct sigaction signalSegFault;
  signalSegFault.sa_handler=signalSegFaultRecu;
  sigaction(SIGSEGV,&signalSegFault,NULL);

  int a= 10/0;
  
  return 0;
}
