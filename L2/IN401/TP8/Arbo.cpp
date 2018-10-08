#include "Arbo.h"

// Liste chainée début
Cellule::Cellule(ContCellule A) {
  fils = A;
  apres = NULL;
}

ListeCellules Cellule::estDansListeP(ContCellule A) {
  if (fils == A)
    return this;

  if (apres == NULL)
    return NULL;
  
  return apres->estDansListeP(A);
}

ListeCellules Cellule::ajouterSuccesseur(ContCellule A) {
  if (!estDansListeP(A)) {
    ListeCellules ptCell = new Cellule(A);
    ptCell->apres = this;
    return ptCell;
  }
  
  return this;
}

ListeCellules Cellule::retirerSuccesseur(ContCellule A) {
  if (fils == A)
    return apres;

  if (!apres)
    return this;

  apres = apres->retirerSuccesseur(A);
  return this;
}
// Liste chainée fin


// Arborescence début
Sommet::Sommet(Valeur v) {
  racine = v;
  listeSuccesseurs = NULL;
}

ListeCellules Sommet::estSuccesseurP(Arbo A) {
  if (listeSuccesseurs) {
    if (listeSuccesseurs->fils == A)
      return listeSuccesseurs;
    
    return listeSuccesseurs->fils->estSuccesseurP(A);
  }
  
  return NULL;
}

void Sommet::ajouterSuccesseur(Arbo A) {
  if (!listeSuccesseurs) {
    listeSuccesseurs = new Cellule(A);
    return;
  }
  
  if (!listeSuccesseurs->estDansListeP(A)) {
    listeSuccesseurs = listeSuccesseurs->ajouterSuccesseur(A);
  }
  
  return;
}

void Sommet::retirerSuccesseur(Arbo A) {
  if (listeSuccesseurs && listeSuccesseurs->estDansListeP(A)) {
    listeSuccesseurs = listeSuccesseurs->retirerSuccesseur(A);
  }
  
  return;
}

ostream& operator<<(ostream& os, Sommet& S) {
  os<<S.racine<<" ";
  return os;
}
// Arborescence fin


// Traversée récursive début
void traverseePrefixeRec(Arbo A) {
  if (!A) {
    cout<<endl;
    return;
  }
  
  cout<<*A<<" ";
  for (ListeCellules l = A->listeSuccesseurs; l != NULL; l = l->apres)
    traverseePrefixeRec(l->fils);
  
  return;
}
// Traversée récursive fin


// Pile début
Pile::Pile() {
  sommet = NULL;
}

bool Pile::videP() {
  return (sommet == NULL);
}

void Pile::empiler(ContCellule A) {
  Cellule* ptCellule = new Cellule(A);
  ptCellule->apres = sommet;
  sommet = ptCellule;
  return;
}

ContCellule Pile::depiler() {
  Cellule* ptCellule = sommet;
  sommet = sommet->apres;
  return ptCellule->fils;
}
// Pile fin


// Traversée préfixe itérative début
void traverseePrefixeIt(Arbo A) {
  Pile* P = new Pile;
  P->empiler(A);
  
  //while ()
}
// Traversée préfixe itérative fin


// File début
File::File() {
  sortie = NULL;
  entree = NULL;
}

bool File::videP() {
  return (sortie == NULL);
}

void File::enfiler(ContCellule A) {
  Cellule* ptCellule = new Cellule(A);
  
  if (entree)
    entree->apres = ptCellule;
  
  entree = ptCellule;
  
  if (!sortie)
    sortie = ptCellule;
  
  return;
}

ContCellule File::defiler() {
  Cellule* ptCellule = sortie;
  sortie = sortie->apres;
  return ptCellule->fils;
}
// File fin


// Traversée largeur début
void traverseeLargeur(Arbo A) {
  
}
// Traversée largeur fin


int main() {
  Arbo A0 = new Sommet(0);
  Arbo A1 = new Sommet(1);
  Arbo A2 = new Sommet(2);
  Arbo A3 = new Sommet(3);
  Arbo A4 = new Sommet(4);
  Arbo A5 = new Sommet(5);
  Arbo A6 = new Sommet(6);

  A3->ajouterSuccesseur(A6);
  A1->ajouterSuccesseur(A5);
  A3->ajouterSuccesseur(A4);
  A2->ajouterSuccesseur(A3);
  A0->ajouterSuccesseur(A2);
  A0->ajouterSuccesseur(A1);

  cout<<"Recursif sur A0: ";
  traverseePrefixeRec(A0);
  cout<<endl;
  cout<<"Iteratif sur A0: ";
  traverseePrefixeIt(A0);
  cout<<endl;
  cout<<"Largeur sur A0: ";
  traverseeLargeur(A0);
  cout<<endl<<endl;
  
  A3->retirerSuccesseur(A5);
  A3->retirerSuccesseur(A2);

  cout<<"Recursif sur A0 apres retrait de 5 et 2: ";
  traverseePrefixeRec(A0);
  cout<<endl;
  cout<<"Iteratif sur A0 apres retrait de 5 et 2: ";
  traverseePrefixeIt(A0);
  cout<<endl;
  
  return 1;
}

// g++ Arbo.cpp -o TP8
