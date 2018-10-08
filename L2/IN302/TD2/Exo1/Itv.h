#include <iostream>
#include <fstream>

class Itv
{
  
 private:
  
  double bi;
  double bs;

 public:

  // Constructeurs
  Itv();
  Itv(double, double);

  // Opérateurs
  bool operator==(Itv) const;
  bool operator!=(Itv) const;
  bool operator<(Itv) const;
  bool operator>(Itv) const;
  bool operator<=(Itv) const;
  bool operator>=(Itv) const;
  void operator+=(double);
  
  // Accesseurs en lecture
  double getbi() const;
  double getbs() const;

  // Accesseurs en écriture
  void setbi(double);
  void setbs(double);

  // 
  void affiche() const;
  double longueur() const;
  bool appartient(double) const;

  // Tests
  bool estEgal(Itv) const;
  bool estInclus(Itv) const;
  bool estDisjoint(Itv) const;
  bool estAccole(Itv) const;
  bool estImbrique(Itv) const;

  //
  void translate(double);
};

// Fonctions
void translate(Itv &I, double);

std::ostream& operator<<(std::ostream&, const Itv&);
std::istream& operator>>(std::istream&, Itv&);
