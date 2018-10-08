#include <iostream>
#include <fstream>


template <typename T>
class Noeud
{
 private:
  T val;
  Noeud<T>* gauche, droit;

 public:
  // Opérateur =
  Noeud& operator=(const Noeud&);
  
  // Accesseurs en lecture
  Noeud<T>* getGauche() const;
  Noeud<T>* getDroit() const;
  T getVal() const;

  // Accesseurs en écriture
  void setGauche(Noeud<T>*);
  void setDroit(Noeud<T>*);
  void setVal(T);

  // Tests booléens
  bool gaucheVide() const;
  bool droitVide() const;
};


template <typename T>
class ABR
{
 private:
  Noeud<T>* racine;

 public:
  // Constructeurs
  ABR();
  ABR(Noeud<T>*);

  // Opérateur =
  ABR& operator=(const ABR&);

  // Accesseur en lecture
  Noeud<T>* getRacine() const;

  // Accesseur en écriture
  void setRacine(Noeud<T>*);
  
  void insert(T); // Insère la valeur dans l'ABR
  bool find(T) const; // Détermine si la valeur appartient à l'ABR
  void load(std::ifstream&); // Insère un ensemble de valeurs dans l'ABR à partir d'un fichier
  void affiche(std::ostream&) const; // Affiche les valeurs de l'ABR dans l'ordre croissant
};
