#include <iostream>
#include <cstdlib>

/***************
Generaux
****************/
int max(int a, int b) {
  if (a > b)
    return a;
  
  return b;
}

int moitieSuperieure(int n){
  if (n % 2 == 0) return n / 2; return (n+1) / 2;
}

void imprimer(int T[], int n){
  for (int i=0; i<n; i++)
    std::cout<<T[i]<<" ";
}

void genererInverse(int n, int T[]){
  for  (int i=0; i<n; i++)
    T[i]=n-i;
}

void genererRandom(int n, int Max, int T[]){ // Rempli le tableau T de n nombres aléatoires, tous entre 0 et Max.
  for  (int i=0; i<n; i++)
    T[i]=rand() %(Max + 1);
}

void echanger(int T[], int i, int j){
  int temp=T[i];
  T[i]=T[j];
  T[j]=temp;
}

// Tris
void triBulle(int T[], int n) { 
  for (int i = 0; i < n; i++) {
    for (int j= 0; j < i-1; j++) {
      if (T[j] > T[j+1]) {
	echanger(T,j,j+1);
      }
    }
  }
}

void triSelection(int T[], int n) {
  int min;
  
  for (int i = 0; i < n; i++) {
    min = i;
    for (int j = i+1; j < n; j++) {
      if (T[j] < T[min]) {
	min = j;
      }
    }

    if (min != i);{
      echanger(T,min,i);
    }
  }
}

int pivot(int T[], int n, int d, int f) {
  int mid = d;

  for (int i = d+1; i < f; i++) {
    if (T[d] > T[i]) {
      mid++;
      echanger(T,i,mid);
    }
  }
  echanger(T,mid,d);

  return mid;
}

void triRapide(int T[], int n, int d, int f) {
  if (d < f) {
    int p = pivot(T,n,d,f);
    triRapide(T,n,d,p-1);
    triRapide(T,n,p+1,f);
  }
}

void triFusion(int T[], int n) {
  
}

void triPanier(int T[], int n) {
  int max= T[0];
    
  for (int i = 1; i < n; i++) {
    if (T[i] > max) {
      max = T[i];
    }
  }

  int TP[max] = {};

  for (int i = 0; i < n; i++) {
    TP[T[i]]++;
  }

  // Affichage du tableau
  for (int i = 0; i < max; i++) {
    std::cout<<TP[i]<<" ";
  }
}

// Main
int main(int argc, char** argv) {
  int n= 10; // Taille du tableau
  int T[n]= {};
  
  // Tri bulle
  genererRandom(10,100,T);

  std::cout<<"Tableau non trie: \n";
  imprimer(T,n);
  std::cout<<"\n";

  triBulle(T,n);

  std::cout<<"Tableau apres tri bulle: \n";
  imprimer(T,n);
  std::cout<<"\n \n";

  // Tri sélection
  genererRandom(10,100,T);
    
  std::cout<<"Tableau non trie: \n";
  imprimer(T,n);
  std::cout<<"\n";

  triSelection(T,n);

  std::cout<<"Tableau apres tri selection: \n";
  imprimer(T,n);
  std::cout<<"\n \n";

  // Tri rapide
  genererRandom(10,100,T);
    
  std::cout<<"Tableau non trie: \n";
  imprimer(T,n);
  std::cout<<"\n";

  triRapide(T,n,0,10);

  std::cout<<"Tableau apres tri rapide: \n";
  imprimer(T,n);
  std::cout<<"\n \n";
  
  // Tri fusion
  genererRandom(10,100,T);
    
  std::cout<<"Tableau non trie: \n";
  imprimer(T,n);
  std::cout<<"\n";

  triFusion(T,n);

  std::cout<<"Tableau apres tri fusion: \n";
  imprimer(T,n);
  std::cout<<"\n \n";
  
  // Tri panier
  genererRandom(10,30,T);
    
  std::cout<<"Tableau non trie: \n";
  imprimer(T,n);
  std::cout<<"\n";

  std::cout<<"Tableau apres tri fusion: \n";
  triPanier(T,n);
  std::cout<<"\n";
  
  return 0;
}

// g++ TriOutilsSimples.cpp -o Main
