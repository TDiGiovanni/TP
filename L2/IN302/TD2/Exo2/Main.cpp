#include <iostream>
#include "Cellule.h"


int main()
{
  Cellule C1 (true, 1, 2);
  Cellule C2 (true, 1, 3);
  
  std::cout<<"L'objet C1 est à l'adresse mémoire "<<&C1<<std::endl;
  std::cout<<"L'objet C2 est à l'adresse mémoire "<<&C2<<std::endl;
  
  std::cout<<"La cellule (à l'adresse mémoire "<<&C1<<") = "<<Test_cell(C1)<<std::endl;

  return 0;
}
