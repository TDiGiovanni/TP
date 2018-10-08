
class Cellule {
 public:
  enum Couleur {
    NOIR,
    BLEU,
    VERT,
    ROUGE,
    JAUNE,
  };

 private:
  unsigned int age, x, y;
  Couleur couleur;

 public:
  // Constructeurs
  Cellule();
  Cellule(bool etat, unsigned int x, unsigned int y);

  // Accesseurs en lecture
  bool getVivante() const;
  unsigned int getX() const;
  unsigned int getY() const;
  Couleur getCouleur() const;

  // Accesseurs en écriture
  void setX(unsigned int x);
  void setY(unsigned int y);
  void setVivante(bool etat);
  
  // affiche la cellule
  void print() const;

  //Recherche Dichotomique
  bool estAvant (const Cellule &c2) const;
  bool estApres (const Cellule &c2) const;
  bool estEquivalente (const Cellule &c2) const;
  bool estDifferente (const Cellule &c2) const;
  bool estAvantOuEquivalente (const Cellule &c2) const;
  bool estApresOuEquivalente (const Cellule &c2) const;
};


// Fonctions

Cellule* creerTab(int n);

void triBulle(Cellule* T, int n);
void triRapide(Cellule* T, int g, int d);
void triTas(Cellule* T, int n);

bool estTriee(Cellule* T, int n);
