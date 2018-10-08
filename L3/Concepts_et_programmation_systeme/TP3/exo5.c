#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

void nbchars (char* fichier) {
  int f= open(fichier,O_APPEND);

  if (f==-1) {
    printf("Erreur : problème lors de l'ouveture du fichier.");
    return;
  }

  int tPresents[256];
  int cpt=0;
  char c;

  while (read(f,&c,1)>0) {
    if (tPresents[c]==0) {
      cpt++;
      tPresents[c]=1;
    }
  }

  printf("Il y a %d caractères différents : ",cpt);
  for (int i=0; i<256; i++)
    if (tPresents[i]==1)
      printf("%c ",i);
}

int main (int agc, char** argv) {
  nbchars(argv[1]);
  
  return 0;
}
