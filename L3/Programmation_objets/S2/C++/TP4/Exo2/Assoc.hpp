#ifndef ASSOC_HPP
#define ASSOC_HPP

#include <iostream>

template<typename TypeCle, typename TypeValeur>
class Assoc {
private:
  TypeCle cle;
  TypeValeur valeur;
  
public:
  Assoc();
  Assoc(TypeCle, TypeValeur);
  
  virtual ~Assoc ();
  
  virtual TypeCle getCle()const;
  virtual void setCle(TypeCle);
  virtual TypeValeur getValeur()const;
  virtual void setValeur(TypeValeur);
  
  virtual void affiche(ostream&)const;
};

template<typename TypeCle, typename TypeValeur>
ostream& operator<<(ostream&, const Assoc<TypeCle,TypeValeur>&);

#endif
