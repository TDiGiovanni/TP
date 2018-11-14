#include <iostream>
#include <string>
#include "Vers.h"
#include "Strophe.h"

using namespace std;

Strophe::Strophe() {
  this->suiteVers=NULL;
  this->nbVers=0;
}

Strophe::~Strophe() {
  if (suiteVers)
    delete[] suiteVers;
}

Vers* Strophe::vers(int i) const {
  if(i>=0 && i<nbVers)
    return suiteVers[i];
  
  else
    return NULL;
}

void Strophe::saisie(istream& is) {
  if (suiteVers)
    delete[] suiteVers;
  
  cout<<"Entrez le nombre de vers : ";
  is>>nbVers;

  suiteVers= new Vers*[nbVers];

  for (int i=0; i<nbVers; i++) {
    Vers* v= new Vers();
    v->saisie(is);
    suiteVers[i]=v;
  }
}

vois Strophe::affiche(ostrea& os) {
  for (int i=0; i<nbVers; i++) {
    suiteVers[i]->affiche(os);
    os<<endl;
  }
}
