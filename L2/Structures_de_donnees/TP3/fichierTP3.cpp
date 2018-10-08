#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "progListeSC.h"
#include "fichierTP3.h"
using namespace std;



bool estTrieeLSC(ListeSC L){
  //   Res : Renvoie true si L est une ListeSC tri�e, false sinon 

  if (estVideLSC(L) || estVideLSC(L->succ))
    return true;
  else
    return (L->info < (L->succ)->info) &&  estTrieeLSC(L->succ);
}



bool estListeIntervalle(ListeSC L){
  //   Res : renvoie true si L est une Liste intervalle, renvoie false sinon

  if (L==NULL)
    return true;
  
  while (estVideLSC(L->succ)==false)
    {
      if ( L->succ->info != (L->info)+1 )
	return false;
      L= L->succ;
    }
  return true;
}

ListeSC consListeIntervalle1(int l, int p){
  //     Donn�e : l>0 
  //     Res : renvoie une liste intervalle de longueur l et dont le premier �l�ment a pour valeur p 
  //     Complexit� : O(l�)
  assert(l>0);
  
  int i; ListeSC L;
  L=NULL;
  for(i=0;i<l;i++)    
    insererFinLSC(L,p+i);
  return L;
}

ListeSC consListeIntervalle2(int l, int p){
  //     Donn�e : l>0 
  //     Res : renvoie une liste intervalle de longueur l et dont le premier �l�ment a pour valeur p 
  //     Complexit� : O(l)
  assert(l>0);

  ListeSC L; L=NULL;
  int i;
  
  for(i=l;i>0;i--)    
    L= creerLSC(p+i-1,L);

  return L;
}


ListeSC consListeIntervalle3(int l, int p){
  //     Donn�e : l>0 
  //     Res : renvoie une liste intervalle de longueur l et dont le premier �l�ment a pour valeur p 
  //     Complexit� : O(l) 
  // Version r�cursive
  assert(l>0);

  if (l!=1)
    return creerLSC(p,consListeIntervalle3(l-1,p+1));

  else
    return creerLSC(p,NULL);
}

void transfListeIntervalle(ListeSC L){
  // Donn�e : L est une liste tri�e non vide  
  // Res : modifie L en y inserant des �l�ments de sorte qu'elle soit une Liste Intervalle 
  assert((L!=NULL));
  assert(estTrieeLSC(L));

  ListeSC P; P= L->succ;
  ListeSC P2; P2= L;
  
  while (P != NULL)
    {
      if (P->info != (P2->info)+1)
	{
	  insererApresLSC(L,P2,(P2->info)+1);
	  P2= P2->succ;
	}
      else
	{
	  P= P->succ;
	  P2= P2->succ;
	}
    }
}

ListeSC intersectionListesIntervalles(ListeSC l1, ListeSC l2){
  // Donn�e : l1 et l2 2 listes intervalles
  // Res : Renvoie l'intersection de l1 et l2; les �l�ments de la liste r�sultat sont recopi�s
  // Complexit� : O()
  assert(estListeIntervalle(l1));
  assert(estListeIntervalle(l2));

  ListeSC L; L= NULL;
  
 /* while (l1!=NULL || l2!=NULL)
    {
      if (l1->info==l2->info)
	{
	  L= creerLSC(l1->info,L);
	}
    }
 */
  return L;
}
  
void plusLgSsLiInterv(ListeSC &L){
  // Donn�e : L liste
  // Res : L est modifiee, elle est la plus longue sous-liste intervalle de la liste en entr�e
  // A COMPLETER

}





