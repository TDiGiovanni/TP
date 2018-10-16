#ifndef CompteRemunere_h
#define CompteRemunere_h

#include "CompteBancaire.h"

class CompteRemunere : virtual public CompteBancaire {
 public :
  CompteRemunere();
  CompteRemunere(double);
  
  ~CompteRemunere();

  void deposer(double);
};

#endif
