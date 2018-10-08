#include <iostream>
#include "CompteDepot.h"

CompteDepot::CompteDepot() {
  this->solde= 0;
}

CompteDepot::CompteDepot(double s) {
  this->solde= s;
}

CompteDepot::~CompteDepot() {
  this->solde-=100;
  std::cout<<"La banque doit vous rendre "<<this->solde<<"€. \n";
}

void CompteDepot::deposer(double s) {
  this->solde+=s-1;
  
  if (s > 1000)
    this->solde+=10;
}
