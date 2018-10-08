#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
  pid_t nPid;
  
  for (int i=0; i<4; i++) {
    pid_t nPid;
    if ((nPid =fork())==0)
      printf("Un nouveau descendant %d de parent %d ! i=%d \n",getpid(),getppid(),i);
    else {
      int status;
      wait(&status);
    }
  }

  return 0;
}
