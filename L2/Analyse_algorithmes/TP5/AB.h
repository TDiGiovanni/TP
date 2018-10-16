typedef int Valeur;

class Sommet;
typedef Sommet* AB;

std::string* TikzRecursAB(int ligne,int gauche, int droite, int numeroPere, int typeFils, AB Ar);

class Sommet {
  protected:
  Valeur racine;
  AB pere, SAG, SAD;

  public:
  Sommet(Valeur v);
  Sommet(Sommet& s);

  void GrefferSAG(AB g);
  void GrefferSAD(AB d);

  void SupprimerSAG();
  void SupprimerSAD();

  bool FeuilleP();

  friend std::string* TikzRecursAB(int ligne,int gauche, int droite, int numeroPere, int typeFils, AB Ar);
};
