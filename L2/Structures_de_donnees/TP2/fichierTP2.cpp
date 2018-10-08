#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "progListeSC.h"

using namespace std;


//  DERNIERLSC ET ESTTRIEELSC 
// Res : Renvoie l'adresse de la derniere cellule de la liste non vide L 
ListeSC dernierLSC(ListeSC L)
{
  assert(L != NULL);

  while (L->succ != NULL)
    {
      L= L->succ;
    }
	 
  return L;
}

//   Res : Renvoie 1 si L est une ListeSC triee, 0 sinon 
int estTrieeLSC(ListeSC L)
{
  bool tri= true;
  
  while ((L->succ != NULL) && (tri==true))
    {
      if ((L->info) > (L->succ->info))
	tri= false;

      L= L->succ;
    }
  
  return tri;
}


//  OTERREPETITION 
//    Res : Supprime de la ListeSC L tous les elements consecutifs egaux 
//          Opere en modifiant le chainage de la ListeSC L 
// version iterative 
void oterRepetitionLSC(ListeSC L)
{
  while (L->succ != NULL)
    {
      if (L->info == L->succ->info)
	L->succ= L->succ->succ;
      else
	L= L->succ;
    }
}

//    Res : Supprime de la ListeSC L tous les elements consecutifs egaux 
//          Opere en modifiant le chainage de la ListeSC L 
//    version recursive 
void oterRepetitionLSCR(ListeSC L)
{
  if (L->succ != NULL)
    {
      if (L->info == L->succ->info)
	{
	  L->succ= L->succ->succ;
	  oterRepetitionLSCR(L);
	}
      else
	oterRepetitionLSCR(L->succ);
    }
}


//   CONCATENATION DE 2 LISTES  
//   Res : Modifie la liste L1 en la concatenant avec la liste l2 
//         Opere en modifiant le chainage de la listeSC L1 
//   Version utilisant la fonction dernierLSC 
void concatLSC(ListeSC& L1,ListeSC L2)
{
  
  
  
}

//   Res : Renvoie la ListeSC obtenue par concatenation des ListeSC L1 et L2 
//         Opere en recopiant les elements des 2 listeSC L1 et L2 
//   complexite : ??? 
ListeSC concatLSCCopie(ListeSC L1,ListeSC L2)
{
  
  
  return NULL;
}


int main(int argc, char *argv[]){
  ListeSC l1,l2,l3;
  int q;
  
  cout << "Numero de la question traitee (1/2/3/4/5) ? ";
  cin >> q;
  switch (q){
  case 1 :  // Test des operations de base sur les listes 
    l1 = lireLSC();

    insererFinLSC(l1,11);
    cout << "Insertion de 11 en derniere position "; afficherLSC(l1);

    insererApresLSC(l1,l1,22);
    cout << "Insertion de 22 en 2eme position "; afficherLSC(l1);

    l1= creerLSC(l1->info,creerLSC(22,l1->succ));
    cout << "Insertion de 22 en 2eme position "; afficherLSC(l1);

    supprimerLSC(l1,l1->succ);
    cout << "Suppression du 2eme element "; afficherLSC(l1);
    
    l1->succ= l1->succ->succ;
    cout << "Suppression du 2eme element "; afficherLSC(l1);

    int temp;
    temp= l1->succ->info;
    l1->succ->info= l1->info;
    l1->info= temp;
    cout << "Inversion des valeurs des 2 premiers elements " ; afficherLSC(l1);
    
    ListeSC temp2;
    temp2= l1;
    l1= l1->succ;
    l1->succ= temp2;
    cout << "Inversion des 2 premiers elements "; afficherLSC(l1);
    break;
    
  case 2 : // Test des fonctions  estTrieeLSC et dernierLSC 
    l1 = lireLSC();
    if (estTrieeLSC(l1))  cout << "Cette liste est triee\n";
    else cout << "Cette liste n'est pas triee\n";
    if (l1 != NULL)
      cout << "La valeur de son dernier element est " << dernierLSC(l1)->info << endl;
    break;
    
  case 3: // Test des fonctions oterRepetitionLSC 
    l1 = lireLSC();
    oterRepetitionLSC(l1);
    cout << "Liste sans repetition (version iterative) :\n";
    afficherLSC(l1);
    l1 = lireLSC();
    oterRepetitionLSCR(l1);
    cout << "Liste sans repetition (version recursive) :\n";
    afficherLSC(l1);
    break;
    
  case 4 :  // Test de la premiere fonction  de concatenation de listes 
    l1 = lireLSC();
    l2 = lireLSC();
    concatLSC(l1,l2);
    cout << "Concatenation des 2 listes (en modifiant le chainage) :\n"; afficherLSC(l1);
    if ((l1 != NULL) && (l2 != NULL) )
      cout << "Adresse derniere cellule de l1 : " << (void *) dernierLSC(l1) << ", de l2 : "<< (void *) dernierLSC(l2) << endl;
    cout << " Ajout de 44 en fin de la liste l1\n";
    insererFinLSC(l1,44);
    cout << "Nouvelle valeur de l1:"; afficherLSC(l1); cout << endl;
    cout << "Nouvelle valeur de l2: "; afficherLSC(l2); cout << endl;
    break;
    
  case 5 :  // Test des fonctions  de concatenation de listes 
    l1 = lireLSC();
    l2 = lireLSC();
    l3 = concatLSCCopie(l1,l2);
    cout << "Concatenation des 2 listes (par recopie des listes) : "; afficherLSC(l3); cout << endl;
    if ((l1 != NULL) && (l2 != NULL) )
      cout << "Adresse derniere cellule de l1 : " << (void *) dernierLSC(l1) << " , de l2 : "  << (void *) dernierLSC(l2) << ", de l3 : " << (void *) dernierLSC(l3) << endl;
    cout << " Ajout de 55 en fin de la liste l1\n";
    insererFinLSC(l1,55);
    cout << "Nouvelle valeur de l1: "; afficherLSC(l1);  cout << endl;
    cout << "Nouvelle valeur de l2: "; afficherLSC(l2); cout << endl;
    cout << "Nouvelle valeur de l3: "; afficherLSC(l3); cout << endl;
    break;
  }
  return 0;
}
