#include <iostream>
#include <string>
#include "Vers.h"

using namespace std;

Vers::Vers() {}

Vers::Vers(string s) {
  this->suiteMots=s;
}

Vers::Vers(string s; string r) {
  this->suiteMots= s;
  this->rime= r;
}

Vers::~Vers() {}

string Vers::getSuiteMots() const {
  return suiteMots;
}

void Vers::setSuiteMots(string s) {
  this.suiteMots= s;
}

string Vers::getRime() const {
  return this.rime;
}

void Vers::setRime(string r) {
  this.rime= r;
}

void Vers::saisie(istream& is) {
  cout<<"Entrez le vers puis la rime : ";
  is>>suiteMots>>rime;
}

void Vers::affiche(ostream& os) {
  os<<"<<"<<SuiteMots<<">> \n";
}
