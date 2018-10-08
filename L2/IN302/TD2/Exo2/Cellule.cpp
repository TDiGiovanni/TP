#include <iostream>
#include "Cellule.h"


Cellule::Cellule (bool e, int a, int b)
{
  etat=e;
  x=a;
  y=b;
}


bool Cellule::getetat() const
{
  return etat;
}


int Cellule::getx() const
{
  return x;
}


int Cellule::gety() const
{
  return y;
}


bool Cellule::estVoisin (Cellule C2) const
{
  bool v;
  
  if ( x == C2.getx()-1 || x == C2.getx() || x == C2.getx()+1 )
    if ( y == C2.gety()-1 || y == C2.gety() || y == C2.gety()+1 )
      v=true;
    else
      v=false;
  else
    v=false;

  return v;
}


void Test_cell (Cellule C1)
{
  std::cout<<"{ "<<C1.getetat<<", ("<<C1.getx()<<","<<C1.gety()<<") }"<<std::endl;
}
