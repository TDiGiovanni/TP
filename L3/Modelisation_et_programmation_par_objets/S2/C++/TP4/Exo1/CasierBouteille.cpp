#include "CasierBouteille.hpp"

CasierBouteille::CasierBouteille() {
  for (int i=0; i<6; i++)
    cases[i]=NULL;
}

CasierBouteille::~CasierBouteille() {}

void CasierBouteille::range(Bouteille* bouteille, int numeroCase) {
  cases[numeroCase]=bouteille;
}
