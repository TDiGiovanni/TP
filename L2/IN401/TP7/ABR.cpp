#include "ABR.h"

SommetABR::SommetABR(Valeur v) {
  racine = v; pere = NULL; SAG = NULL; SAD = NULL;
}

SommetABR::SommetABR(SommetABR& s) {
  racine = s.racine; SAG = NULL; SAD = NULL;
  
  if (s.SAG)
    GrefferSAG(new SommetABR(*(s.SAG)));
  
  if (s.SAD)
    GrefferSAD(new SommetABR(*(s.SAD)));
}

void SommetABR::GrefferSAG(ABR g) {
  SAG = new SommetABR(*g);
}

void SommetABR::GrefferSAD(ABR d) {
  SAD = new SommetABR(*d);
}

void SommetABR::SupprimerSAG() {
  if (SAG != NULL) {
    SAG->pere = NULL;
    SAG = NULL;
  }
}

void SommetABR::SupprimerSAD() {
  if (SAD != NULL) {
    SAD->pere = NULL;
    SAD = NULL;
  }
}

bool SommetABR::FeuilleP() {
  if (SAG == NULL && SAD == NULL)
    return true;

  return false;
}

void SommetABR::RemplacerPourPere(ABR a) {
  pere->SAG = a;
}

ABR SommetABR::PlusPetit(){
  if ( SAG != NULL )
    return SAG->PlusPetit();
  
  return this;
}

ABR SommetABR::RechercherVal(Valeur v){
  if ( v == racine )
    return this;

  if ( SAD != NULL && v > racine )
    return SAD->RechercherVal(v);

  if ( SAG != NULL && v < racine )
    return SAG->RechercherVal(v);

  return NULL;
}

void SommetABR::InsererVal(Valeur v){
  if ( v <= racine ) {
    if ( SAG != NULL )
      SAG->InsererVal(v);
    
    else {
      SAG = new SommetABR(v);
      SAG->pere = this;
    }
  }

  if ( v > racine ) {
    if ( SAD != NULL )
      SAD->InsererVal(v);

    else {
      SAD = new SommetABR(v);
      SAD->pere = this;
    }
  }
}

ABR SommetABR::SupprimerVal(Valeur v){
  ABR a = RechercherVal(v);
  ABR b = a->SAD->PlusPetit();
  Valeur temp;
  
  temp = b->racine;
  b->racine = a->racine;
  a->racine = temp;
  b->pere->GrefferSAG(b->SAD);
  b->pere->SupprimerSAG();
    
  return this;
}

ABR SommetABR::SupMin(){
  return SupprimerVal(PlusPetit()->racine);
}

// Main
int main() {
  ABR A1 = new SommetABR(11);
  A1->InsererVal(5);
  A1->InsererVal(15);
  A1->InsererVal(3);
  A1->InsererVal(9);
  A1->InsererVal(7);
  A1->InsererVal(8);
  A1->InsererVal(10);
  SortieLatex(A1,"A1");
  
  ABR A2 = new SommetABR(11);
  A2->InsererVal(5);
  A2->InsererVal(15);
  A2->InsererVal(3);
  A2->InsererVal(9);
  A2->InsererVal(7);
  A2->InsererVal(8);
  A2->InsererVal(10);
  A2->SupprimerVal(5);
  SortieLatex(A2,"A2");
	      
  return 1;
}

// g++ ABR.cpp SortieLatex.cpp -o TP7
