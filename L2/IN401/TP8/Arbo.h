#ifndef ARBO_H
#define ARBO_H

#include <iostream>
#include <sstream>

using namespace std;

typedef int Valeur;

// Liste chainée début
struct Sommet;
typedef Sommet* Arbo;
typedef Arbo ContCellule;

struct Cellule;
typedef Cellule* ListeCellules;

struct Cellule {
  ContCellule fils;
  ListeCellules apres;

  Cellule(ContCellule);

  ListeCellules estDansListeP(ContCellule); 
  // Si A apparait dans la liste, renvoie un pointeur sur la sous-liste commençant par A, sinon renvoie NULL 

  ListeCellules ajouterSuccesseur(ContCellule);
  // Si A appartenait déjà à la liste renvoie la liste, sinon rajoute A en tete et renvoie la nouvelle liste


  ListeCellules retirerSuccesseur(ContCellule);
  // Renvoie la liste d'où a été retirée A s'il lui appartenait (sinon renvoie la liste initiale)
};
// Liste chainée fin


// Arborescence début
struct Sommet {
  Valeur racine;
  ListeCellules listeSuccesseurs;
 
  Sommet(Valeur);

  ListeCellules estSuccesseurP(Arbo);
  // Si A apparait dans la liste listeSuccesseurs, renvoie un pointeur sur la sous-liste de listeSuccesseurs commençant par A, sinon renvoie NULL

  void ajouterSuccesseur(Arbo);
  // Rajoute A comme fils ainé

  void retirerSuccesseur(Arbo);
  // Si A était un fils, il cesse de l'être
};

ostream& operator<<(ostream&, Sommet&);
// Arborescence fin


// Traversée récursive début
void traverseePrefixeRec(Arbo);
// Traversée récursive fin


// Pile début
struct Pile {
  ListeCellules sommet;

  Pile();

  bool videP();
  void empiler(ContCellule);
  ContCellule depiler(); // Pas défini si la pile est vide
};
// Pile fin


// Traversée préfixe itérative debut
void traverseePrefixeIt(Arbo);
// Traversée préfixe itérative fin


// File début
struct File {
  ListeCellules sortie;
  ListeCellules entree;

  File();

  bool videP();
  void enfiler(ContCellule);
  ContCellule defiler(); // Pas défini si la pile est vide
};
// File fin


// Traversée largeur début
void traverseeLargeur(Arbo);
// Traversée largeur fin

#endif
