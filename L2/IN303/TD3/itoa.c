#include <stdio.h>
#include <stdlib.h>


char* itoa2 (int n)
{
  int N= n;
  int longueur=0;
  
  while (N != 0)
    {
      N= N/10;
      longueur++;
    }

  
  int valeur=0;
  char* chaine= malloc(longueur*(sizeof(char)));
  
  while (n != 0)
    {
      valeur= n%10;
      n= n/10;
      chaine[longueur-1]= valeur+48;
      longueur--;
    }
  
  return chaine;
}


int main (int argc, char** argv)
{
  printf("La valeur est %s \n", itoa2(123));

  return 0;
}
