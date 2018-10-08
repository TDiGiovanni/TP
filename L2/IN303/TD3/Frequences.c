#include <stdio.h>
#include <stdlib.h>


float* calculFrequences (char* fichier)
{


  file* fd;
  if (fd=fopen(chaines,"r"))!=0)
  {
    unsigned int c;
    while ((c=fgetc(fd))!=EOF)
      {
	printf("%i \n", c);
	
      }
  }
  else
    {
	
    }
