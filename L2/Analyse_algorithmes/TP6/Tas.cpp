#include <cmath>
#include "Tas.h"

// ArbreParfait
ArbreParfait::ArbreParfait(int h) {
  hauteur = h;
  IndicePremierSommetLibre = 0;
  contenu = new int[pow(2,h+1)-1];
}

void ArbreParfait::Echanger(indiceDansTableauSommet a, indiceDansTableauSommet b) {
  indiceDansTableauSommet temp;
  
  temp = contenu[a];
  contenu[a] = contenu[b];
  contenu[b] = temp;
}

int ArbreParfait::AjouteSommetArbreParfait(int s) {
  if ( 2*IndicePremierSommetLibre+1 < pow(2,hauteur+1)-1 ) {
    if ( FeuilleP(IndicePremierSommetLibre) ) {
      contenu[FilsGauche(IndicePremierSommetLibre)] = s;
      return FilsGauche(IndicePremierSommetLibre);
    }
    else {
      contenu[FilsDroit(IndicePremierSommetLibre)] = s;
      return FilsDroit(IndicePremierSommetLibre);
    }
  }
  
  return -1;
}

bool ArbreParfait::SommetValide(int s) {
  if (contenu[FilsGauche(s)] == NULL && contenu[FilsDroit(s)] != NULL)
    return false;

  return true;
}

indiceDansTableauSommet ArbreParfait::Racine() {
  return 0;
}

bool ArbreParfait::FeuilleP(indiceDansTableauSommet s) {
  if ( contenu[FilsGauche(s)] == NULL )
    return true;

  return false;
}

indiceDansTableauSommet ArbreParfait::Pere(indiceDansTableauSommet fils) {
  return fils/2;
}

indiceDansTableauSommet ArbreParfait::FilsGauche(indiceDansTableauSommet pere) {
  return 2*pere;
}

indiceDansTableauSommet ArbreParfait::FilsDroit(indiceDansTableauSommet pere) {
  return 2*pere+1;
}

void ArbreParfait::SupprimerArbreParfait(indiceDansTableauSommet s) {
  
}


// Tas
Tas::Tas(int i) {

}
