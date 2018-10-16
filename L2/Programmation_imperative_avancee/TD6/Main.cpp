#include <iostream>
#include <cstdlib>
#include "Cellule.h"

using namespace std;


int main (int argc, char** argv)
{
  int n; Cellule* T;
  
  cout<<"Entrez la taille du tableau: ";
  cin>>n;

  T=creerTab(n);
  triRapide(T,0,n-1);

  if ( estTriee(T,n) )
    cout<<"Tableau trié. \n";
  else
    cout<<"Tableau non trié. \n";
  
  return 0;
}
