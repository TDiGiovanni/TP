#include <iostream>
#include <cstdlib>
#include "Tab.h"

using namespace std;


// Classe tabint

tabint::tabint (int n)
{
  t= new int[n];
  this->n= n;
}

tabint::tabint (tabint& t2)
{
  n= t2.n;
  t= new int[n];

  for (int i=0; i<n; i++)
    {
      t[i]= t2.at(i);
    }
}

tabint::~tabint()
{
  delete[] t;
}

tabint& tabint::operator= (tabint& t2)
{
  if (this != &t2)
    {
      delete[] t;
      n= t2.n;
      t= new int[n];

      for (int i=0; i<n; i++)
	{
	  t[i]= t2.at(i);
	}
    }
  return *this;
}

int& tabint::at (int n)
{
  return this->t[n];
}

int tabint::getn() const
{
  return n;
}

void tabint::extend()
{
  if (


// Fonctions

void write (ostream& s, tabint& t)
{
  for (int i=0; i<t.getn(); i++)
    {
      s<<t.at(i)<<endl;
    }
}


// Main

int main (int argc, char** argv)
{
  if (argc !=2)
    {
      cerr<<"Usage: "<<argv[0]<<" [tab dim] \n";
      return 1;
    }

  int n= atoi(argv[1]);
  tabint t(n);

  for (int i=0; i<n; i++)
    {
      t.at(i)= i+1;
    }

  write(cout,t);

  return 0;
}
