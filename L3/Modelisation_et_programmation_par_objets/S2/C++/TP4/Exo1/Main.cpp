#include "Casier6.hpp"

int main (int argc, char** argv) {
  Bouteille* b= new Bouteille();
  Oeuf* o= new Oeuf();

  Casier6<Oeuf*>* co= new Casier6<Oeuf*>();
  co->range(o,4);
  
  return 0;
}
