#include <iostream>
#include <cmath>
#include <stdlib.h>
#include "fonctionsMysterieuses.h"


// Renvoie a puissance b
int apuissanceb(int a, int b) {
  if (b == 0) {
    return 1;
  }
  
  if (b%2 == 0) {
    return apuissanceb(a*a, b/2);
  }

  return a*apuissanceb(a, b-1);
}


// Incrémente le nombre binaire dans T de 1, et renvoie le nombre d'affectations faites dans la tableau
int incrementer(int n, bool* T) {
  int aff=0, i=n-1;

  while (i>0) {
    if (T[i] == 0) {
      T[i]= 1;
      aff++;
      i= 0;
    }
    else {
      T[i]= 0;
      aff++;
      i--;
    }
  }
  
  return aff;
}


// Compte le nombre moyen d’affectations que l’on effectue quand on incrémente tous les tableaux qui représentent les entiers entre 0 et (2^n)−1.
int compte(int n) {
  bool T[n]= {};
  int aff= 0, k= 0;

  // Initialisation du tableau
  for (int i= 0; i< n; i++) {
    T[i]= 0;
  }

  while (k != apuissanceb(2,n)-1) {
    aff+= incrementer(n,T);
    k++;
  }
  
  return aff;
}


// Main
int main(int argc, char** argv) {
  // Variable pour Q1
  float rap;

  // Variables pour Q2.1
  int n1= 8;
  bool T[n1]={0,1,1,1,1,1,1,1};

  // Variable pour Q2.2
  int n2= 28;
  
  // Question 1
  std::cout<<"Question 1: \n";
    
  for (int i=1000; i<= 1100; i+=20) {
    rap = ((float) (f1(i)) / (sqrt(i)));
    std::cout<<"f1("<<i<<") / sqrt("<<i<<") renvoie "<<rap<<"\n";
  }
  std::cout<<"On peut donc en deduire que f1 est racine de n, la constante etant 3. \n\n";
  
  for (int i=1000; i<= 1100; i+=20) {
    rap = ((float) (f2(i)) / (apuissanceb(i,5)));
    std::cout<<"f2("<<i<<") / apuissanceb("<<i<<",5) renvoie "<<rap<<"\n";
  }
  std::cout<<"On peut donc en deduire que f2 est n puissance 5, la constante etant 0.1. \n\n";
  
  for (int i=1000; i<= 1100; i+=20) {
    rap = ((float) (f3(i)) / (apuissanceb(i,2)));
    std::cout<<"f3("<<i<<") / apuissanceb("<<i<<",2) renvoie "<<rap<<"\n";
  }
  std::cout<<"On peut donc en deduire que f3 est n carre, la constante etant 0.5. \n\n";
  
  for (int i=1000; i<= 20000; i+=3000) {
    rap = ((float) (f4(i)) / (log(i)));
    std::cout<<"f4("<<i<<") / log("<<i<<") renvoie "<<rap<<"\n";
  }
  std::cout<<"On peut donc en deduire que f4 est log(n), la constante etant 2. \n\n";
  
  for (int i=10; i<= 20; i+=2) {
    rap = ((float) (f5(i)) / (apuissanceb(2,i)));
    std::cout<<"f5("<<i<<") / apuissanceb(2,"<<i<<") renvoie "<<rap<<"\n";
  }
  std::cout<<"On peut donc en deduire que f5 est 2 puissance n, la constante etant 10. \n\n";

  for (int i=0; i<= 10; i+=2) {
    rap = ((float) (f6(i)) / (apuissanceb(3,i)));
    std::cout<<"f6("<<i<<") / apuissanceb(3,"<<i<<") renvoie "<<rap<<"\n";
  }
  std::cout<<"On peut donc en deduire que f6 est 3 puissance n, la constante etant 20. \n\n";

  
  // Question 2.1
  std::cout<<"Question 2.1: \n";
  
  std::cout<<"Le nombre d'affectations pour le tableau T de taille "<<n1<<" est "<<incrementer(n1,T)<<". \n\n";

  // Question 2.2
  std::cout<<"Question 2.2: \n";
  std::cout<<"Le nombre moyen d'affectations pour tous les tableaux d'entiers entre 0 et (2^"<<n2<<")-1 est "<<compte(n2)<<". \n";
  	
  return 0;
}

// Ordre de compilation :  g++ SolutionsFonctionMysterieuses.cpp fonctionsMysterieuses.o -o Main

