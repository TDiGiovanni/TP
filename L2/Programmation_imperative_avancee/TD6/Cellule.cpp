#include <iostream>
#include <cstdlib>
#include "Cellule.h"

using namespace std;


// Classe Cellule

// Constructeurs
Cellule::Cellule(): age(0), x(0), y(0), couleur(NOIR)
{
  
}

Cellule::Cellule(bool etat, unsigned int x, unsigned int y):
  age(etat ? 1 : 0), x(x), y(y), couleur(etat ? BLEU : NOIR)
{
  
}


// Accesseurs en lecture
bool Cellule::getVivante() const
{
  return age;
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

void Cellule::setVivante(bool etat)
{
  if (etat) {
    couleur = age++ ? VERT : BLEU;
  } else {
    age = 0;
    couleur = NOIR;
  }
}


// Recherche dichotomique
bool Cellule::estAvant (const Cellule &c2) const
{
  if (x<c2.x || (x==c2.x && y<c2.y))
    return true;
  else
    return false;
}

bool Cellule::estApres (const Cellule &c2) const
{
  if (x>c2.x || (x==c2.x && y>c2.y))
    return true;
  else
    return false;
}

bool Cellule::estEquivalente (const Cellule &c2) const
{
  if (!estAvant(c2) && !estApres(c2))
    return true;
  else
    return false;
}

bool Cellule::estDifferente (const Cellule &c2) const
{
  if (!estEquivalente(c2))
    return true;
  else
    return false;
}

bool Cellule::estAvantOuEquivalente (const Cellule &c2) const
{
  if (estAvant(c2) || estEquivalente(c2))
    return true;
  else
    return false;
}

bool Cellule::estApresOuEquivalente (const Cellule &c2) const
{
  if (estApres(c2) || estEquivalente(c2))
    return true;
  else
    return false;
}


// Fonctions
Cellule* creerTab(int n)
{
  srand(time(NULL));

  Cellule* T= new Cellule[n];
  
  int i,j;
  
  for (int k= 0 ; k<n ; k++)
    {
      i=rand() %50;
      j=rand() %50;
      
      T[k]=Cellule(true,i,j);
    }

  return T;
}


void triBulle (Cellule* T, int n)
{
  int i=0;
  Cellule temp;
    
  while (i<n)
    {
      if (T[i].estApres(T[i+1]))
	{
	  temp=T[i];
	  T[i]=T[i+1];
	  T[i+1]=temp;
	  i= 0;
	}
      else
	i++;
    }
}


void triRapide(Cellule* T, int g, int d)
{
  if (g<d)
    {
      int m= (g+d)/2, inf=g, sup=d;
      Cellule p=T[m], temp;
      
      while (inf<sup)
	{
	  while (inf<m && T[inf].estAvantOuEquivalente(p))
	    {
	      inf++;
	    }

	  while (sup>m && T[sup].estApres(p))
	    {
	      sup--;
	    }
	  temp=T[inf];
	  T[inf]=T[sup];
	  T[sup]=temp;

	  if (m==inf)
	    {
	      m=sup+1;
	    }
	  else
	    {
	      if (m==sup)
		{
		  m=inf-1;
		}
	    }
	  inf++;
	  sup--;
	}
      
      triRapide(T,g,m);
      triRapide(T,m+1,d);
    }
}


void triTas(Cellule* T, int n)
{
  
}

void entasser (Cellule* T, int n, int i)
{
  
}


bool estTriee(Cellule* T, int n)
{
  bool trie= true; int i=1;

  while (i<n && trie==true)
    {
      if ( T[i-1].estApres(T[i]) )
	trie= false;

      i++;
    }
  
  return trie;
}
