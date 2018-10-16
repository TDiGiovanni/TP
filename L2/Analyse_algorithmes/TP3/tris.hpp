#ifndef __TP3__TRIS__
#define __TP3__TRIS__

/**
 * tri du tableau @p Tab de taille @p n
 * avec le tri par insertion en Θ(n²)
 *
 * @param Tab tableau d'entier
 * @param n taille de tableau Tab
**/
void triInsertion(int* Tab , int taille);


/**
 * tri du tableau @p Tab de taille @p n
 * avec le tri à bulle en Θ(n²)
 *
 * @param T tableau d'entier
 * @param n taille de tableau Tab
**/
void triBulle(int* Tab , int taille);


/**
 * tri du tableau @p Tab de taille @p n
 * avec le tri par selection en Θ(n²)
 *
 * @param Tab tableau d'entier
 * @param n taille de tableau Tab
**/
void triSelection(int* Tab , int taille);


/**
* initialise l'appel récursif de triFusionRec
*
* @param Tab tableau d'entier
* @param n taille de tableau Tab
**/
void triFusion(int* Tab , int taille);

/**
 * tri du tableau @p Tab de taille @p n
 * avec le tri par fusion en Θ(n log n)
 *
 * @param Tab tableau d'entier
 * @param d indice du début du tableau
 * @param f indice de fon du tableau
**/
void triFusionRec(int* Tab , int d , int f);

/**
 * Tri le talbeau @p Tab
 *
 * @param Tab tableau d'entier trié croissant entre @p d
 * et @p mil et entre @p mil + 1 et @p f
 * @param d indice du début du tableau
 * @param mil indice du début du tableau
 * @param f indice de fin du tableau
**/
void fusion(int* Tab , int d , int mil, int f);


/**
 * tri du tableau @p Tab de taille @p n
 * avec le tri à panier en Θ(n)
 *
 * @param T tableau d'entier
 * @param n taille de tableau Tab
**/
void triPanier(int* Tab , int taille);


/**
* initialise l'appel récursif de triRapideRec
*
* @param Tab tableau d'entier
* @param n taille de tableau Tab
**/
void triRapide(int* Tab , int taille);

/**
 * tri du tableau @p Tab de taille @p n
 * avec le tri à rapide en Θ(n²)
 *
 * @param T tableau d'entier
 * @param n taille de tableau Tab
**/
void triRapideRec(int* T, int deb, int fin);

#endif
