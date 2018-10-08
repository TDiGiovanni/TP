#include <iostream>
#include "CompteRemunere.h"

CompteRemunere::CompteRemunere() {
  this->solde= 0;
}

CompteRemunere::CompteRemunere(double s) {
  this->solde= s;
}

CompteRemunere::~CompteRemunere() {
  this->solde+=this->solde*0.1;
  std::cout<<"La banque doit vous rendre "<<this->solde<<"€. \n";
}

void CompteRemunere::deposer(double s) {
  this->solde+= s+(s*0.01);
}
