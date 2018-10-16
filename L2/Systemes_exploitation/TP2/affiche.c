#include <stdio.h>


int main (int argc, char** argv, char** env)
{
  
  printf("Le programme a %i paramètres \n", argc);

  printf("Les paramètres sont: \n");
  for (int i=0; i<argc; i++)
    {
      printf("%s \n", argv[i]);
    }

  int k=0;
  printf("Les variables d'environnement sont: \n");
  while (env[k]!=0)
    {
      printf("%s \n", env[k]);
      k++;
    }
  
  return 0;
}
