#include <iostream>
#include <string>
#include "Options.h"

using namespace std;

#define Nb_opt 10

// Classe option
// Constructeurs
option::option ()
{
  numéro=-1;
  nom="Vide";
  raccourci="Vide";
  description="Vide";
  type=None;
}

option::option (int numero, string nom, string raccourci, string description, Type type)
{
  this->numero= numero;
  this->nom= nom;
  this->raccourci= raccourci;
  this->description= description;
  this->type= type;
}

// Accesseurs en écriture
void option::set_num (int num)
{
  numero= num;
}

void option::set_nom (string name)
{
  nom= name;
}

void option::set_raccourci (string racc)
{
  raccourci= racc;
}

void option::set_description (string descr)
{
  description= descr;
}

void option::set_type (Type type)
{
  this->type= type;
}


// Accesseurs en lecture
int option::get_num () const
{
  return numero;
}

string option::get_nom () const
{
  return nom;
}

string option::get_raccourci () const
{
  return raccourci;
}

Type option::get_type () const
{
  return type;
}



// Classe toption
void toption::ajouter (option Option)
{
  int i=0;
  while (i<Nb_opt && toption[i].get_num()!=-1)
    i++;

  toption[i].set_num(Option.get_num());
  toption[i].set_nom(Option.get_nom());
  toption[i].set_raccourci(Option.get_raccourci());
  toption[i].set_description(Option.get_raccourci());
  toption[i].set_type(Option.get_type());
}

void toption::afficher () const
{
  int i=0;
  while (i<Nb_opt && toption[i].get_num()!=-1)
    {
      cout<<
