#include <stdio.h>
#include <stdlib.h>

// Q1.2
int* extract(int T[], int n, int a, int b) {
  int newN= 0;
  
  for (int i= 0; i<n; i++) {
    if (a <= T[i] && T[i] <= b)
      newN++;
  }

  int* newT= malloc(newN*sizeof(int));

  int k= 0;
  for (int i= 0; i<n; i++) {
    if (a <= T[i] && T[i] <= b) {
      newT[k]= T[i];
      printf("newT[%i] = %i \n",k,T[i]);
      k++;
    }
  }
  
  return newT;
}

// Q1.3
int somme(int T[], int n) {
  n = n-1;
  
  if (n == 0)
    return T[n];
  else
    return T[n] + somme(T,n);
}


int main(int argc, char** argv) {
  // Q1.1
  int a= 10;
  int b= 25;
  int* p = &b;
  int* pp = &a;

  // Q1.2
  int n= 5;
  int T[5]= {1,3,5,7,9};
  int x= 2;
  int y= 5;

  // Q1.3
  int m;
  
  printf("Entrez la taille du tableau : \n");
  scanf("%i",&m);

  int P[m];

  printf("Entrez %i nombres : \n",m);
  
  for (int i = 0; i<m; i++)
    scanf("%i",&P[i]);

  printf("Somme de tous les éléments du tableau : %i \n",somme(P,m));
  
  return 0;
}
