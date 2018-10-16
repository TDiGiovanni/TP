#include <iostream>
#include "exo2.h"

// Classe MyVector
// Constructeurs
template <typename T>
MyVector::MyVector(): data(NULL), n(0), alloc(0)
{

}

template <typename T>
MyVector::MyVector(unsigned int n): data(new T[n]), n(n), alloc(n)
{
  
}

// Destructeur
template <typename T>
MyVector::~MyVector()
{
  delete[] data;
}

// Opérateur =
template <typename T>
T& MyVector::operator=(const MyVector& V)
{
  if (this!=&V)
    {
      delete[] data;
      data=new T[V.n];
      n=V.n;
      alloc=n;
      for(size_t i=0;i<n;i++)
	{
	  data[i]=V.data[i];
	}    
    }
  return *this;
}

// Accesseur en lecture
template <typename T>
const T& MyVector::at(unsigned int i) const
{
  return data[i];
}

// Ajouter élément
template <typename T>
void MyVector::extend()
{
  if (n<alloc) return;
  alloc=2*n;
  T* temp=new T[alloc];
  for(size_t i=0;i<n;i++)
    {
      temp[i]=data[i];
    }
  delete[] data;
  data=temp;
}

template <typename T>
void MyVector::push_back(const T& V)
{
  extend();
  data[n]=V;
  n++;
}

// Taille tableau
template <typename T>
unsigned int MyVector::size()const
{
  return n;
}

// Trouver élément
template <typename T>
int MyVector::find(const T& V) const
{
  for (size_t i=0;i<n;i++)    
    if (V=data[i])
      return i;	
  return -1;
}

// Supprimer élément
template <typename T>
void MyVector::erase(int idx)
{
  if (idx>=0 && idx<(int)n)
    {
      for(size_t i=idx; i<n-1; i++)
	data[i]=data[i+1];
      n--;
    }  
}

// Fonction
template <typename T>
void write(std::ostream& os) const
{
  os<<"Code générique: ";
  for(size_t i=0;i<n;i++)
    {
      write2(os,data[i]);
    }
}
