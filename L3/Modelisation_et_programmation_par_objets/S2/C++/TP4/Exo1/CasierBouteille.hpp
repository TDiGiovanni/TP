#ifndef CASIERBOUTEILLE_HPP
#define CASIERBOUTEILLE_HPP

#include "Bouteille.hpp"

class CasierBouteille {
private:
  Bouteille* cases[6];
  
public:
  CasierBouteille();
  virtual ~CasierBouteille();
  
  virtual void range(Bouteille* bouteille, int numeroCase);
};

#endif
