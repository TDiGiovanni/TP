#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// Trouver la taille max d'un tube
int main(int argc, char** argv) {
  char c ='x';
  int desc[2]; // 0 pour lecture, 1 pour écriture
  if (pipe(desc) == -1) {
    printf("Erreur lors de l'ouverture du tube. \n");
    return EXIT_FAILURE;
  }

  int i=1;
    while (1) {
      write(desc[1],&c,sizeof(c));
      printf("%d \n",i);
      i++;
    }
  
  return EXIT_SUCCESS;
}
