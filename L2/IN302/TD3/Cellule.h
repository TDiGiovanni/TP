class Cellule
{
 public:

  enum Couleur
  {
    Noir,
    Bleu,
    Vert,
    Rouge,
    Jaune,
  };

  
 private:
  
  bool etat;
  unsigned int x, y;
  Couleur couleur;

  
 public:

  // Constructeurs
  Cellule(bool etat, unsigned int x, unsigned int y);
  

  // Accesseurs en lecture
  bool getEtat() const;
  unsigned int getX() const;
  unsigned int getY() const;
  Couleur getCouleur() const;
  

  // Accesseurs en écriture
  void setX(unsigned int x);
  void setY(unsigned int y);
  void setEtat(bool etat);
  

  // Renvoie vrai si la cellule C2 est voisine de C
  bool estVoisine(Cellule C2) const;
  
  
  // Affiche les attributs de la cellule
  void print() const;
  
};


#define N 4

class Population
{
 private:

  Cellule C[N][N];

  
 public:

  // Constructeur
  Population ();
  
  // Accesseurs en lecture
  unsigned int getVivantes() const;
  unsigned int getMortes() const;
  unsigned int getNees() const;
  unsigned int getMourantes() const;
  
  // Méthodes
  void Init(unsigned int k);

  unsigned int NbCellules(Cellule::Couleur c) const;

  void print() const;
  void printCell(unsigned int i, unsigned int j) const ;

  void kill(unsigned int i, unsigned int j);
  void birth(unsigned int i, unsigned int j);

  Cellule getCopieCellule(unsigned int i, unsigned int j) const;

  void updateC();
};
