#include <stdio.h>
#include <stdlib.h>


int atoi2 (char* chaine)
{
  int k=0;
  int som=0;
  
  while (chaine[k]!='\0')
    {
      k++;
    }

  for (int i=0; i<k; i++)
    {
      int a= 48;
      while (a<57)
	{
	  if (chaine[i]==a)
	    som= (som*10) + (a-48);
	  a++;
	}
    }

  return som;
}


int main (int argc, char** argv)
{
  printf("%i \n", atoi2("123"));

  return 0;
}
