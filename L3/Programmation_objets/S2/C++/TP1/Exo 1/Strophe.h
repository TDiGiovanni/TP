#ifndef Strophe_h
#define Strophe_h

class Strophe {
 private:
  Vers** suiteVers; // Tableau de pointeurs de vers
  int nbVers;
  
 public:
  // Constructeur par défaut
  Strophe();

  // Destructeur
  virtual ~Strophe();
  
  virtual Vers* vers(int i) const;
  virtual void saisie(istream& is);
  virtual void affiche(ostream& os) const;
};

#endif
