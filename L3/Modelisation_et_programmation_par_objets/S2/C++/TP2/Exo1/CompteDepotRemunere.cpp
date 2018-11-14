#include "CompteDepotRemunere.h"

CompteDepotRemunere::CompteDepotRemunere(): CompteRemunere(), CompteDepot() {}

CompteDepotRemunere::CompteDepotRemunere(double s): CompteRemunere(s), CompteDepot(s) {}

void CompteDepotRemunere::deposer(double s) {
  CompteRemunere::deposer(s);
}

