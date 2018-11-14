#include <iostream>
#include "CompteRemunereAvecCredit.h"

CompteRemunereAvecCredit::CompteRemunereAvecCredit() {
  this->solde= 0;
}

CompteRemunereAvecCredit::CompteRemunereAvecCredit(double s) {
  this->solde= s;
}

CompteRemunereAvecCredit::~CompteRemunereCredit() {
  this->solde-=5;
  std::cout<<"La banque doit vous rendre "<<this->solde<<"€. \n";
}

double CompteRemunereAvecCredit::deposer(double s) {
  this->solde+= s+(s*0.01);
  return this->solde;
}
