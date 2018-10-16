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
char* codes[256];



float* calculFrequences (char* fichier)
{
  FILE* fd=fopen(fichier,"r");
  float* frequences=(float*) malloc(256*sizeof(float));

  if (fd != 0)
    {
      unsigned int c=fgetc(fd);
      int som= 0;
      
      while (c != EOF)
	{
	  frequences[c]++;
	  som++;
	  c=fgetc(fd);
        }

      for (int i=0; i<=255; i++)
	{
	  frequences[i]= frequences[i]/som;
	}
  
    }
      
  else
    {
      printf("Erreur: fichier vide");
    }

  return frequences;
}



void constructionArbre (float* frequences)
{
  int p= 256;
  float freq1=1, freq2=1;
  unsigned int min1, min2;
  
  for (int i= 0; i<511; i++)
    {
      if (i<256 && frequences[i]!=0)
	{
	  arbre[i].pere=-1;
	  arbre[i].fg=-1;
	  arbre[i].fd=-1;
	  arbre[i].freq= frequences[i];
	}
  
      else
	{
	  arbre[i].pere=-1;
	  arbre[i].fg=-1;
	  arbre[i].fd=-1;
	  arbre[i].freq=0;
	}
    }
      
  while (arbre[p-1].freq!=1)
    {
      for (int i= 0; i<511; i++)
	{
	  if (arbre[i].freq!=0 && arbre[i].pere==-1 && arbre[i].freq<freq1)
	    {
	      freq2= freq1;
	      min2= min1;
	      freq1= arbre[i].freq;
	      min1= i;
	    }
	  else
	    if (arbre[i].freq!=0 && arbre[i].pere==-1 && arbre[i].freq<freq2)
	      {
		freq2= arbre[i].freq;
		min2= i;
	      }
	}
      
      arbre[p].fg=min2;
      arbre[p].fd=min1;
      arbre[p].freq=freq1+freq2;
      
      arbre[min1].pere=p;
      arbre[min2].pere=p;

      freq1=1;
      freq2=1;
      p++;
    }

    for (int i=0; i<511; i++)
      {
	if (arbre[i].freq!=0)
	  {
	    printf("%i= {Père: %i, fils gauche: %i, fils droit: %i, fréquence: %f} \n", i, arbre[i].pere, arbre[i].fg, arbre[i].fd, arbre[i].freq);
	  }
      }
}



void parcoursArbre (int noeud, char* code)
{
  if (arbre[noeud].fg!=-1)
    {
      int i=0;
      while (code[i]!='\0')
	{
	  i++;
	}
      char* code2= strdup(code);

      code2[i]='0';
      parcoursArbre(arbre[noeud].fg,code2);
      
      code2[i]='1';
      parcoursArbre(arbre[noeud].fd,code2);
    }
  else
    {
      codes[noeud]=code;
      printf("Le code de %c est %s \n", noeud, code);
    }
}



void compression (char** codes, char* fichier, char* fichier2)
{
  char buffer[262];
  FILE* fd=fopen(fichier2,"w");
  FILE* fe=fopen(fichier,"r");
  unsigned int e=fgetc(fe);
  int i=0, j=0, valeur=0;
  
  if (fe != 0)
    {
      for (int a=0; a<511; a++)
	{
	  if (arbre[a].freq != 0)
	    {
	      fputc(a,fd);
	      fputc(arbre[a].pere,fd);
	      fputc(arbre[a].fg,fd);
	      fputc(arbre[a].fd,fd);
	      fputc(arbre[a].freq,fd);
	    }
	}
      fputc('\n',fd);
      
      while (e != EOF)
	{
	  while (codes[e][j]!='\0')
	    {
	      buffer[i] = codes[e][j];
	      i++;
	      j++;
	    }
      
	  if (i>=7)
	    {
	      for (int k=7; k>=0; k--)
		{
		  if (buffer[k]=='1')
		    {
		      valeur+= pow(2,7-k);
		    }
		}

	      fputc(valeur,fd);
	      
	      for (int k=0; k<254; k++)
		{
		  buffer[k]=buffer[k+8];
		}
	      
	      i=i-7;
	      valeur=0;
	    }

	  j=0;
	  e= fgetc(fe);
	}
    }
  
  else
    {
      printf("Erreur: fichier vide");
    }

  fclose(fd);
}
		 
  
      


int main (int argc, char** argv)
{
  constructionArbre(calculFrequences(argv[1]));

  int i= 0;
  while (arbre[i].freq != 1)
    {
      i++;
    }
  
  parcoursArbre(i,"");
  
  compression(codes,argv[1],argv[2]);

  return 0;
}
