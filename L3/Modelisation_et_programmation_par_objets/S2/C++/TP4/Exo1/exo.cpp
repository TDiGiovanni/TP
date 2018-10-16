#include <iostream>
#include <string>

template <typename type>
void echange(type& e1, type& e2) {
  type aux=e1;
  e1=e2;
  e2=aux;
}

template <typename type>
void triBulles(type T[], int tailleT) {
  int i=tailleT-2, j;
  bool ech=true;
  while (i>=0 && ech) {
    ech=false;
    for (j=0; j<=i; j++)
      if (T[j]>T[j+1]) {
	echange(T[j],T[j+1]);
	ech=true;
      }
    i--;
  }
}


int main (int argc, char** argv) {
  int n= 3;
  std::string* ts= new std::string[n];
  
  ts[0]= "test";
  ts[1]= "abcedfg";
  ts[2]= "lol";

  std::cout<<"Avant tri : \n";
  for (int i=0; i<n; i++)
    std::cout<<"ts["<<i<<"]= "<<ts[i]<<std::endl;
  
  triBulles(ts,n);

  std::cout<<"Après tri : \n";
  for (int i=0; i<n; i++)
    std::cout<<"ts["<<i<<"]= "<<ts[i]<<std::endl;
}
