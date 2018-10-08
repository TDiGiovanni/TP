#include <stdio.h>
#include <stdlib.h>

int pascal (int n, int p) {
  int** Pascal= malloc(1+n*sizeof(int*));

  for (int i=0; i<=n; i++) {
    Pascal[i]= malloc((i+1)*sizeof(int));
    
    Pascal[i][0]=1;
    printf("%d ",Pascal[i][0]);
    
    for (int j=1; j<i; j++) {
      Pascal[i][j]= Pascal[i-1][j-1]+Pascal[i-1][j];
      printf("%d ",Pascal[i][j]);
    }
    
    Pascal[i][i]= 1;
    if (i != 0)
      printf("%d ",Pascal[i][i]);
    printf("\n");
  }
  
  return Pascal[n][p];
}

int main (int argc, char** argv, char** arge) {
  int n, p;
  
  printf("Entrez une valeur pour n : ");
  scanf("%d",&n);

  printf("Entrez une valeur pour p : ");
  scanf("%d",&p);
  
  printf("Le nombre de combinaisons possibles est %d. \n",pascal(n,p));

  return 0;
}
