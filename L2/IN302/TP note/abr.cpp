#include "abr.h"


// Classe Noeud
// Opérateur =
template <typename T>
Noeud<T>& Noeud<T>::operator=(const Noeud<T>& Noeud2)
{
  val= Noeud2.getVal();
  gauche= Noeud2.getGauche();
  droit= Noeud2.getDroit();
  return this;
}

// Tests booléens
template <typename T>
bool Noeud<T>::gaucheVide() const
{
  if (gauche==NULL)
      return true;
  else
    return false;
}

template <typename T>
bool Noeud<T>::droitVide() const
{
  if (droit==NULL)
      return true;
  else
    return false;
}

// Accesseurs en lecture
template <typename T>
Noeud<T>* Noeud<T>::getGauche() const
{
  return gauche;
}

template <typename T>
Noeud<T>* Noeud<T>::getDroit() const
{
  return droit;
}

template <typename T>
T Noeud<T>::getVal() const
{
  return val;
}

// Accesseurs en écriture
template <typename T>
void Noeud<T>::setGauche(Noeud* n)
{
  gauche= n;
}

template <typename T>
void Noeud<T>::setDroit(Noeud* n)
{
  droit= n;
}

template <typename T>
void Noeud<T>::setVal(T valeur)
{
  val= valeur;
}


// Classe ABR
// Constructeurs
template <typename T>
ABR<T>::ABR()
{
  racine= NULL;
}

template <typename T>
ABR<T>::ABR(Noeud<T>* n)
{
  racine= n;
}

// Opérateur =
template <typename T>
ABR<T>& ABR<T>::operator=(const ABR& ABR2)
{
  racine= ABR2.getRacine();
  return this;
}

// Accesseur en lecture
template <typename T>
Noeud<T>* ABR<T>::getRacine() const
{
  return racine;
}

// Accesseur en écriture
template <typename T>
void ABR<T>::setRacine(Noeud<T>* n)
{
  racine= n;
}

template <typename T>
void ABR<T>::insert (T valeur) // Insère la valeur dans l'ABR
{  
  if ( racine.getVal() < valeur )
    if ( racine.droitVide() )
      (racine.droit).setVal(valeur);
    else
      (racine.droit).insert(valeur);
  
  else
    if ( racine.gaucheVide() )
      (racine.gauche).setVal(valeur);
    else
      (racine.gauche).insert(valeur);
}

template <typename T>
bool ABR<T>::find(T valeur) const // Détermine si la valeur appartient à l'ABR
{
  if ( racine.gaucheVide() && racine.droiteVide() )
    return false;
  
  if (valeur == racine)
    return true;
  else
    if ( valeur <= racine.getVal() )
      return (racine.gauche).find(valeur);
    else
      return (racine.droit).find(valeur);
}

template <typename T>
void ABR<T>::load(std::ifstream& file) // Insère un ensemble de valeurs dans l'ABR à partir d'un fichier
{
  
}

template <typename T>
void ABR<T>::affiche(std::ostream& os) const // Affiche les valeurs de l'ABR dans l'ordre croissant
{
  if (racine.gauche != NULL)
    (racine.gauche).affiche(os);
  
  os<<racine.getVal();

  if (racine.droit != NULL)
    (racine.droit).affiche(os);
}
