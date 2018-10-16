#ifndef DICTIONNAIRE_HPP
#define DICTIONNAIRE_HPP

#include "Assoc.hpp"

template <typename typeCle, typename typeVal>
class Dictionnaire {
private:
  Assoc<typeCle,typeVal>* dico;
  
public:
  static int hash(string, int);
  
  void put(typeCle, typeVal);
  typeCle get(typeVal);

  bool estVide();

  unsigned int taille();

  bool contient(typeCle);

  void affiche(ostream& const);
};

template<typename typeCle, typename typeVal>
ostream& operator<<(ostream& const, Dictionnaire<typeCle,typeVal>& const);

#endif
