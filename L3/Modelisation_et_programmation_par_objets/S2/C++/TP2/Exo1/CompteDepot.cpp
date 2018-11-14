#include <iostream>
#include "CompteDepot.h"

CompteDepot::CompteDepot(): CompteBancaire() {}

CompteDepot::CompteDepot(double s): CompteBancaire(s) {}

CompteDepot::~CompteDepot() {
  this->solde-=100;
  std::cout<<"La banque doit vous rendre "<<this->solde<<"€. \n";
}

void CompteDepot::deposer(double s) {
  this->solde+=s-1;
  
  if (s > 1000)
    this->solde+=10;
}
