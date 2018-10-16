#include <stdio.h>
#include <stdlib.h>


void strsplit (char* chaines, char sep)
{
  int k=1;
  int a=0;
  
  while (chaines[a]!='\0')
    {
      if (chaines[a]==sep)
	k++;
      a++;
    }

  char** Tchaines= malloc((k+1)*sizeof(char*));

  int j=0;
  for (int i=0; i<k-1; i++)
    {
      while (chaines[j]!='\0' && chaines[j]!=sep)
	{
	  Tchaines[i][j]=chaines[j];
	  j++;
	}
      if (chaines[j]!='\0')
	j++;
    }
  Tchaines[k-1]="NULL";

  for (int z=0; z<k; z++)
    {
      printf("%s", Tchaines[z]);
    }

}

int main ()
{
  strsplit("/bin:/usr/bin:/local/usr/bin",':');

  return 0;
}
