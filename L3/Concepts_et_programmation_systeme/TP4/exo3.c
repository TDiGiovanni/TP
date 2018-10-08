#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>



int main (int argc, char** argv) {
  int i=1;
  int* j= malloc(sizeof(int));
  *j=5;
  static int k=7;

  pid_t p;

  switch (p= fork()) {
  case -1:
    printf("Erreur. \n");
    break;

  case 0:
    i++;
    printf("i = %d \n",i);
    printf("Adresse de i = %p \n",&i);
    break;

  default:
    printf("i = %d \n",i);
    printf("Adresse de i = %p \n",&i);
  }
  
  return 0;
}
