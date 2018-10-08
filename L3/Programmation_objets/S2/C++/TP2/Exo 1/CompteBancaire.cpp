#include <iostream>
#include "CompteBancaire.h"


CompteBancaire::CompteBancaire() {
  this->solde= 0;
}

CompteBancaire::CompteBancaire(double s) {
  this->solde= s;
}

CompteBancaire::~CompteBancaire() {
  std::cout<<"La banque doit vous rendre "<<this->solde<<"€. \n";
}

double CompteBancaire::getSolde() {
  return this->solde;
}

void CompteBancaire::setSolde(double s) {
  this->solde= s;
}

void CompteBancaire::deposer(double s) {
  this->solde+=s;
}
