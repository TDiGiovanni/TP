#include <iostream>
#include <fstream>
#include <stdlib.h>  // pour rand
#include <assert.h>
#include "outilsTab5.h"

using namespace std;



int* copieTab(int* T, size_t t){
  int* Tc;
  Tc=new int[t];
  for( size_t i=0;i<t;i++)Tc[i]=T[i];
  return Tc;
}

int* genTab(size_t n){
    int* T; 
    T=new int[n];
    for (size_t i=0;i<n;i++) T[i]=rand();
    return T;
}

void afficheTab(int* T,	size_t taille){
  cout << "\n[ ";
  for (size_t i=0;i<taille;i++) cout << T[i] << " ";
  cout << "]\n";
}

void echanger(int& a, int& b){int aux=a; a=b; b=aux; return;}

void fichierTemps(const char *  nomFic, size_t tMaxTab, size_t pas, void (*fTri)(int*,size_t))
{
    size_t taille;
    int* Tab;
    clock_t t1, t2;    
    ofstream fichier(nomFic,ios::out);

    if (fichier)
    {
        for (taille=pas; taille<=tMaxTab; taille=taille+pas){
            Tab=genTab(taille);
            t1=clock();
            (*fTri)(Tab,taille);
            t2=clock();
            fichier << taille <<" "<< (double)(t2-t1)/ CLOCKS_PER_SEC << endl;
        }
        fichier.close();
    }
    else cerr << " Problème ouverture fichier"<< endl;

    return ;
}



/* ********************** Les Tris *********************** */

/* Tri par insertion */
void triInsertion(int* T, size_t taille)
{
  int temp;
  size_t j;
  
  for (size_t i=1; i<taille; i++)
    {
      j= i;
      while (j>0 && T[j]<T[j-1])
	{
	  temp= T[j];
	  T[j]= T[j-1];
	  T[j-1]= temp;
	  j--;
	}
    }

  return;
}




/* Tri par Sélection */
void triSelection(int* T, size_t taille)
{
  size_t j=0;
  int min, temp;

  while (j<taille)
    {
      min= j;
      
      for (size_t i= j; i<taille; i++)
	{
	  if (T[i]<T[min])
	    min= i;
	}

      temp= T[min];
      T[min]= T[j];
      T[j]= temp;

      j++;
    }

  return;
}




/* Tri par Tas */
size_t filsMax(int* T, size_t i, size_t iMax)
{
  if ((i*2+2>iMax) || (T[2*i+1]>T[2*i+2])) return 2*i+1;
  else return 2*i+2;
}
void triParTas(int* T, size_t taille)
{
  size_t i,j,k; 
  for (i=1;i<taille;i++){
    j=i;
    while(j>0 && T[(j-1)/2]<T[j]){
      echanger(T[j],T[(j-1)/2]);
      j=(j-1)/2;}}
  for (i=taille-1;i>0;i--){
    echanger(T[0],T[i]);
    j=0;
    while( (2*j+1<i) && T[filsMax(T,j,i-1)]>T[j]){
      k=filsMax(T,j,i-1);
      echanger(T[j],T[k]);
      j=k;} }
  return;
}





/* Tri Rapide */
void triRapInd1(int* T, size_t deb, size_t fin)
/* trie le sous-tableau T[g..d] selon le tri rapide */
{
  
  
  return;
}

void triRapide1(int* T, size_t taille)
{
  triRapInd1(T,0,taille-1);
  return;
}




/* tri par Fusion */
void triFusionBis(int* T, size_t g, size_t d)
/* trie le sous-tableau T[g..d] par fusion */
{
  
  
  return;
}
void triFusion(int* T, size_t taille)
{
  triFusionBis(T,0,taille-1);
  return;
}
 






/* Nombre de valeurs différentes dans un tableau */
int nbValDiff(int T[], size_t taille)
// Complexité : O(n*log(n)+n)
{
  triParTas(T,taille);

  int k=0;
  
  for (size_t i=0; i<taille-1; i++)
    {
      if (T[i]!=T[i+1])
	k++;
    }
  
  return k;
  
}



/* nbValDiff sans tri

Nombre de valeurs différentes dans un tableau
int nbValDiff(int T[], size_t taille)
// Complexité : O(trop grand)
{
  int k=0, a= T[0];
  size_t j= 0;
  
  for (size_t i=0; i<taille; i++)
    {
      if (T[i] != a)
	{
	  while (j<i || T[j]!=T[i])
	    j++;

	  if (j!=i)
	    k++;

	  a= T[i];
	  j= 0;
	}
    }
  
  return k;
  
}
*/
