#include "Cellule.h"
#include <iostream>


int main()
{
  Cellule Pop3[3][3]=
    {
      Cellule(false,0,0),
      Cellule(true,0,1),
      Cellule(false,0,2),
      Cellule(true,1,0),
      Cellule(false,1,1),
      Cellule(true,1,2),
      Cellule(false,2,0),
      Cellule(true,2,1),
      Cellule(false,2,2),
    };

  /*  unsigned int i, j;
  std::cout<<"Quelle cellule voules-vous modifier?"<<std::endl;
  std::cin>>i>>j;

  Pop3[i][j].setEtat(!(Pop3[i][j].getEtat()));
  Pop3[i][j].print(); */


  
  return 0;
}
