#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main (int argc, char** argv) {
  printf("PID après recouvrement : %d \n",getpid());

  return 0;
}
