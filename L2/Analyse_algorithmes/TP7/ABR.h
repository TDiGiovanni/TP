#ifndef ABR_H
#define ABR_H

#include <iostream>
#include <sstream>
#include <cstdlib>
#include <fstream>

using namespace std;

typedef int Valeur;

class SommetABR;

typedef SommetABR* ABR;

class SommetABR  {
 public:
  Valeur racine;
  ABR pere, SAG, SAD;
  
 public:
  SommetABR(Valeur v);
  SommetABR(SommetABR& s);
  
  void GrefferSAG(ABR);
  void GrefferSAD(ABR);
  
  void SupprimerSAG();
  void SupprimerSAD();
  
  bool FeuilleP();

  void RemplacerPourPere(ABR);
  
  friend std::string* TikzRecursABR(int ligne,int gauche, int droite, int numeroPere, int typeFils, ABR Ar);
  
  // ABR
  ABR PlusPetit();
  ABR RechercherVal(Valeur);
  void InsererVal(Valeur);
  ABR SupprimerVal(Valeur); // Notez la dissymétrie
  ABR SupMin();
};

void SortieLatex(ABR,string);

#endif
