#include <iostream>
#include "CompteDepot.h"
#include "CompteRemunere.h"

#define N 6

int main (int argc, char** argv) {
  CompteBancaire** comptesVP= new CompteBancaire*[N];

  comptesVP[0]= new CompteBancaire();
  comptesVP[1]= new CompteBancaire();
  comptesVP[2]= new CompteDepot();
  comptesVP[3]= new CompteDepot();
  comptesVP[4]= new CompteRemunere();
  comptesVP[5]= new CompteRemunere();

  for (int i=0; i<N; i++) {
    comptesVP[i]->deposer(100);
    std::cout<<i<<" : "<<comptesVP[i]->getSolde()<<std::endl;
    
  }

  delete[] comptesVP;
  
  return 0;
}
