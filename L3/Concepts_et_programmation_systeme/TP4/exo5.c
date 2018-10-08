#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main (int argc, char** argv) {
  printf("tcho... \n");
  execl("/bin/ls","ls -l",NULL);
  printf("ouioui \n");
  
  return 0;
}
