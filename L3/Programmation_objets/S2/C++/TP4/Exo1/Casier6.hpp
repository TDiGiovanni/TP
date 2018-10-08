#ifndef CASIER6_HPP
#define CASIER6_HPP

#include "Bouteille.hpp"
#include "Oeuf.hpp"

template <typename t>
class Casier6 {
private:
  t* cases[6];

public:
  //t operator[](int);

  void range(t*, int);
};

#endif
