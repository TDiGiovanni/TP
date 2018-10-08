#include <stdio.h>
#include <unistd.h>

void proc() {
  pid_t f;
  switch (f=fork()) {
  case -1:
    printf("Erreur. \n");

  case 0:
    printf("Dans le fils de pid : %d. Pid du père : %d. \n",getpid(),getppid());
    
  default:
    printf("Dans le père de pid : %d. Fils : %d. \n",getpid(),f);
  }
}

int main (int argc, char** argv) {
  proc();
  
  return 0;
}
