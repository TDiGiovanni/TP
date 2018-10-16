#include <stdio.h>
#include <stdlib.h>


int main (int argc, char** argv)
{
  float moy=0;
  
  for (int i=1; i<argc; i++)
    {
      moy=moy+atoi(argv[i]);
    }

  moy=moy/(argc-1);
  
  printf("La moyenne des paramètres est %f \n", moy);
  
  return 0;
}
