#ifndef vers_h
#define vers_h

class Vers {
 private:
  string suiteMots;
  string rime;

 public:
  // Constructeurs
  Vers();
  Vers(string);
  Vers(string, string);

  // Destructeur
  virtual ~Vers();

  // Accesseurs
  virtual string getSuiteMots() const;
  virtual void setSuiteMots(string);
  virtual string getRime() const;
  virtual void setRime(string);

  virtual void saisie(istream&);
  virtual void affiche(ostream&);
};

#endif
