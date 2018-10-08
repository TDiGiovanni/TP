#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main (int argc, char** argv) {
  
  if(atoi(argv[1])== 0){
    printf("BOUYAH !mdrrrrrrrr \n");
    return 0;
  }
  
  printf("PID = %d, i = %s \n", getpid(), argv[1]);
  int i = atoi(argv[1]);
  i--;
  
  char string[5];
  sprintf(string,"%d",i);
  
  execl("/auto_home/tdigiovanni/Bureau/IN504/TP4/exo7-1","exo7-1",string,NULL);

  return 0;
}
