#include "mm.h"
#include <stdlib.h>

mm mm_creer() {
  mm jeu=malloc((TAILLE+1)*sizeof(int*)+sizeof(int));
  int lettre;
  
  for (int i=0; i<TAILLE; i++) {
    lettre= rand()%9;
    
    for (int j=0; j< i; j++)
      if (lettre == jeu->secret[j]) {
	lettre= rand()%9;
	j=0;
      }
    
    jeu->secret[i]= lettre;
  }

  return jeu;
}

void mm_detruire(mm jeu) {
  free(jeu);
}

int mm_test(mm jeu, char* essai) {
  if (sizeof(essai) != sizeof(jeu->secret))
    return -1;
  else {
    jeu->nbessais++;
    int nb=0;
    
    for (int i=0; i<TAILLE; i++) {
      if (essai[i]==jeu->secret[i])
	nb+=(TAILLE+1);
      else
	for (int j=0; j<TAILLE; j++) 
	  if (essai[j]!=jeu->secret[j] &&
	      essai[i]==jeu->secret[j])
	    nb+=1;
    }
  }
}

int mm_nbessais(mm jeu) {
  return jeu->nbessais;
}
