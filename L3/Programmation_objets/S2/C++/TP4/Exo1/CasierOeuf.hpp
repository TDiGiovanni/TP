#ifndef CASIEROEUF_HPP
#define CASIEROEUF_HPP

#include "Oeud.hpp"

class CasierOeuf {
private:
  Oeuf* cases[6];
  
public:
  CasierOeuf();
  virtual ~CasierOeuf();
  
  virtual void range(Oeuf* oeuf, int numeroCase);
};

#endif
