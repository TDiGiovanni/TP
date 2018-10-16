#ifndef CompteDepotRemunere_h
#define CompteDepotRemunere_h

#include "CompteDepot.h"
#include "CompteRemunere.h"

class CompteDepotRemunere : virtual public CompteRemunere, virtual public CompteDepot {
 public :
  CompteDepotRemunere();
  CompteDepotRemunere(double);

  ~CompteDepotRemunere();

  void deposer(double);
};

#endif
