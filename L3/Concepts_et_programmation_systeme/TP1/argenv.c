#include <stdlib.h>
#include <stdio.h>

int main (int argc, char** argv, char** arge) {
  printf("Nombre d'arguments : %d \n",argc);
  
  for (int i=0; i<argc; i++) {
    printf("%s \n", argv[i]);
  }

  int j=0;
  while (arge[j] != NULL) {
    printf("%s \n", arge[j]);
    j++;
  }

  printf("Nombre de variables d'environnements : %d \n",j);
  
  return 0;
}
