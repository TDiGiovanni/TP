#include <string>
#include "Dictionnaire.hpp"

int Dictionnaire::hash(string s, int tailleTab) {
  int k=0;
  
  // Calcul d’un entier associé à la string
  for (int i=0; i<s.length(); i++)
    k+=(i+1)*s[i];
  
  // Adaptation à la taille du tableau
  return (k % tailleTab);
}

template <typename typeCle, typename typeVal>
void Dictionnaire::put(typeCle cle, typeVal val) {
  
}

template <typename typeCle, typename typeVal>
typeCle Dictionnaire::get(typeVal val) {
  
}

template <typename typeCle, typename typeVal>
bool Dictionnaire::estVide() {
  unsigned int i=0;
  bool trouve= false;
  
  while (i<this->taille() && !trouve) {
    if (dico[i]!=NULL)
      trouve =true;

    i++;
  }
  
  return !trouve;
}

template <typename typeCle, typename typeVal>
unsigned int Dictionnaire::taille {
  unsigned int t=0;

  while (dico[t]!=NULL)
    t++;

  return t;
}

template <typename typeCle, typename typeVal>
bool Dictionnaire::contient(typeCle cle) {
  unsigned int i=0;
  bool trouve= false;
  
  while (i<this->taille() && !trouve) {
    if (dico[i].getCle()==cle)
      trouve= true;
    
    i++;
  }

  return trouve;
}

template <typename typeCle, typename typeVal>
void Dictionnaire::affiche(ostream& os const) {
  for (unsigned int i=0; i<this->taille(); i++)
    os<<dico[i].affiche(os)<<std::endl;
}

template <typename typeCle, typename typeVal>
ostream& operator<<(ostream& os const, Dictionnaire<typeCle,typeVal>& dico const) {
  dico.affiche(os);

  return os;
}
