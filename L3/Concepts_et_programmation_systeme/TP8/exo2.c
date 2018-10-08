#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void ecriture() {
  int desc[2]; // 0 pour lecture, 1 pour écriture
  if (pipe(desc) == -1) {
    printf("Erreur lors de l'ouverture du tube. \n");
    return (EXIT_FAILURE);
  }
  
  while (1);
}

void lecture() {
  int desc[2];
  if (pipe(desc) == -1) {
    printf("Erreur lors de l'ouverture du tube. \n");
    exit(EXIT_FAILURE);
  }

  read(desc[0])
}

int main(int argc, char** argv) {
  int p;
  printf("Entrez 0 pour processus écrivain, 1 pour processus lecteur : ");
  scanf("%d",&p);

  if (p==0)
    ecriture();
  else
    lecture();

  return EXIT_SUCCESS;
}
