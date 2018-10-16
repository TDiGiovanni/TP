#include "Cellule.h"
#include <iostream>
#include <string>
#include <cstdlib>


// Constructeur
Cellule::Cellule(bool etat, unsigned int x, unsigned int y)
{
  this->etat=etat; this->x=x; this->y=y; couleur=(etat? Bleu : Noir);
}


// Accesseurs en lecture
bool Cellule::getEtat() const
{
  return etat;
}


unsigned int Cellule::getX() const
{
  return x;
}


unsigned int Cellule::getY() const
{
  return y;
}


Cellule::Couleur Cellule::getCouleur() const
{
  return couleur;
}


// Accesseurs en écriture
void Cellule::setX(unsigned int x)
{
  this->x = x;
}


void Cellule::setY(unsigned int y)
{
  this->y = y;
}


void Cellule::setEtat(bool etat)
{
  this->etat= etat;
}


// Méthodes
bool Cellule::estVoisine(Cellule C2) const
{
  bool v;
  
  if ( x == C2.getX()-1 || x == C2.getX() || x == C2.getX()+1 )
    if ( y == C2.getY()-1 || y == C2.getY() || y == C2.getY()+1 )
      v=true;
    else
      v=false;
  else
    v=false;

  return v;
}


void Cellule::print() const
{
  std::string CouleurStr[5]= {"noir","bleu","vert","rouge","jaune"};
  
  std::cout<<"Les coordonnées de la cellule sont ("<<x<<","<<y<<"), sa couleur est "<<CouleurStr[couleur]<<std::endl;
}


// Constructeur
Population::Population()
{
  for (unsigned int i=0; i<N; i++)
    for (unsigned int j=0; j<N; j++)
      {
	C[i][j].setX(i);
	C[i][j].setY(j);
	C[i][j].setEtat(false);
      }
}


// Accesseur en lecture
unsigned int Population::getVivantes() const
{
  unsigned int k=0;
  
  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
      if (C[i][j].getEtat()==true)
	k++;

  return k;
}


unsigned int Population::getMortes() const
{
  unsigned int k=0;
  
  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
      if (C[i][j].getEtat()==false)
	k++;

  return k;
}


unsigned int Population::getNees() const
{
  unsigned int k=0;
  
  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
      if (C[i][j].getCouleur()=='Bleu')
	k++;

  return k;
}


unsigned int Population::getMourantes() const
{
  unsigned int k=0;
  
  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
      if (C[i][j].getCouleur()=='Rouge' || C[i][j].getCouleur()=='Jaune')
	k++;

  return k;
}


void Population::Init (unsigned int k)
{
  unsigned int i, j, n=0;
  srand(time(NULL));
  
  while (n<k)
    {
      i= rand() %N;
      j= rand() %N;
      if (C[i][j].getEtat()==false)
	{
	  C[i][j].setEtat(true);
	  n++;
	}
    }
}


unsigned int Population::NbCellules (Cellule::Couleur c) const
{
  unsigned int k=0;
  
  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
      if (C[i][j].getCouleur()==c)
	k++;

  return k;
}
