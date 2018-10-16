#ifndef CompteDepot_h
#define CompteDepot_h

#include "CompteBancaire.h"

class CompteDepot : public CompteBancaire {
 public :
  CompteDepot();
  CompteDepot(double);
  
  ~CompteDepot();

  void deposer(double);
};

#endif
