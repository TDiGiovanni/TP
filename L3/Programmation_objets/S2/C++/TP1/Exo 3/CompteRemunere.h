#ifndef CompteRemunere_h
#define CompteRemunere_h

#include "CompteBancaire.h"

class CompteRemunere : public CompteBancaire {
 public :
  CompteRemunere();
  CompteRemunere(double);
  
  ~CompteRemunere();

  void deposer(double);
};

#endif
