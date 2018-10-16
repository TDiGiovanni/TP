#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


 
typedef struct noeud
{
  int pere, fg, fd;
  float freq;
} noeud;

noeud arbre[511];



void recupArbre (char* fichier)
{
  FILE* fd=fopen(fichier,"r");
  int a;
  unsigned int e= fgetc(fd);

  for (int i= 0; i<511; i++)
    {
      arbre[i].pere=-1;
      arbre[i].fg=-1;
      arbre[i].fd=-1;
      arbre[i].freq= 0;
    }
  
  while (e != '\n')
    {
      a= e;
      arbre[a].pere= fgetc(fd);
      arbre[a].fg= fgetc(fd);
      arbre[a].fd= fgetc(fd);
      arbre[a].freq= fgetc(fd);
      e= fgetc(fd);
    }
  
  for (int i=0; i<511; i++)
    {
      if (arbre[i].freq!=0)
	{
	  printf("%i= {Père: %i, fils gauche: %i, fils droit: %i, fréquence: %f} \n", i, arbre[i].pere, arbre[i].fg, arbre[i].fd, arbre[i].freq);
	}
    }
}



void recupCode ()
{
  FILE* fd=fopen(fichier,"r");
  unsigned int e= fgetc(fd);

  while (e != '\n')
    {
      e= fgetc(fd);
    }
  e= fgetc(fd);
  
  while (e != EOF)
    {
      
      e= fgetc(fd);
    }
}


int main (int argc, char** argv)
{
  recupArbre(argv[1]);

  return 0;
}
