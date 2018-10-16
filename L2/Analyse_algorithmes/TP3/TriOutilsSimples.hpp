#ifndef __TP3__TRIOUTILSSIMPLES__
#define __TP3__TRIOUTILSSIMPLES__

/**
 * Impretion du tableau @p Tab de taille @p n
 *
 * @param Tab tableau d'entier
 * @param n taille de tableau Tab
**/
void imprimer(int* Tab, int n);

/**
 * Initialise le tableau @p Tab de taille @p n
 * avec des valeurs inférieur ou égal à @p Max
 *
 * @param Tab tableau d'entier
 * @param n taille de tableau Tab
 * @param Max valeur maximum possible dans le tableau
**/
void genererRandom(int* Tab , int n , int Max);

/**
 * Echange les valeurs @p i et @p j du tableau @p Tab
 *
 * @param Tab tableau d'entier
 * @param i Indice d'une valeur à échanger
 * @param j Indice d'une valeur à échanger
**/
void echanger(int* T, int i, int j);

//int moitieSuperieure(int n);
//void genererInverse(int n, int* T);
//int max(int a, int b);

#endif
