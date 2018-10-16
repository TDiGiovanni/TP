#include "AB.h"

Sommet::Sommet(Valeur v) {
  racine = v;
  pere = NULL;
  SAG = NULL;
  SAD = NULL;
}

Sommet::Sommet(Sommet& s){
  racine = s.racine;
  pere = s.pere;
  SAG = s.SAG;
  SAD = s.SAD;
}

bool Sommet::FeuilleP(){
  if (SAG == NULL && SAD == NULL)
    return true;

  return false;
}

void Sommet::SupprimerSAG(){
  if (SAG != NULL) {
    SAG.pere = NULL;
    SAG = NULL;
  }
}

void Sommet::SupprimerSAD(){
  if (SAD != NULL) {
    SAD.pere = NULL;
    SAD = NULL;
  }
}

void Sommet::GrefferSAG(AB g){
  supprimerSAG();
  SAG = g;
}

void Sommet::GrefferSAD(AB d){
  supprimerSAD();
  SAD = d;
 }

void Sommet::RemplacerLePerePar(AB Ar){
  //le pere existe
  //à implémenter
}


int main(int argc, char** argv) {
  
  
  return 0;
}
