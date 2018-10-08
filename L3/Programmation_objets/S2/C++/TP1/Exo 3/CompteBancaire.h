#ifndef CompteBancaire_h
#define CompteBancaire_h

class CompteBancaire {
 protected :
  double solde;

 public :
  CompteBancaire();
  CompteBancaire(double);
  
  ~CompteBancaire();

  double getSolde();
  void setSolde(double);

  virtual void deposer(double);
};

#endif
