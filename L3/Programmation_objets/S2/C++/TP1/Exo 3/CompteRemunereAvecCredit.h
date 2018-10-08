#ifndef CompteRemunereAvecCredit_h
#define CompteRemunereAvecCredit_h

#include "CompteRemunere.h"

class CompteRemunereAvecCredit : public CompteRemunere {
 public :
  CompteRemunereAvecCredit();
  CompteRemunereAvecCredit(double);
  
  ~CompteRemunereAvecCredit();

  double deposer(double);
};

#endif
