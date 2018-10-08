#include <stdio.h>
#include <stdlib.h>

int fact (int n) {
  if (n == 0)
    return 1;
  else
    return n*fact(n-1);
}

int main (int argc, char** argv, char** arge) {
  printf("Entrez un entier : ");
  int n;
  scanf("%d",&n);

  printf("La factorielle de %d est %d \n",n,fact(n));

  return 0;
}
