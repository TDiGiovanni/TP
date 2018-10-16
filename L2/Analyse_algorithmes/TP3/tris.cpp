#include <iostream>
#include <limits>

#include "tris.hpp"
#include "TriOutilsSimples.hpp"

void triInsertion(int* Tab , int taille)
{
    for (int posValTest=0 ; posValTest<taille ; posValTest++)
    {
        int savValTest = Tab[posValTest];
        int p = posValTest;

        while ( p > 0 and Tab[p-1] > savValTest)
        {
            Tab[p] = Tab[ p-1 ];
            p--;
        }
        Tab[p]=savValTest;
    }
}


void triBulle(int* Tab , int taille)
{
    for (int i=taille-1 ; i>=1 ; i--)
    {
        for (int j=0 ; j<i ; j++)
        {
            if ( Tab[j+1] < Tab[j] )
            {
                echanger( Tab , j+1 ,j);
            }
        }
    }
}


void triSelection(int* Tab , int taille)
{
    int i=0;
    int j=0;

    for( i=0 ; i<taille ; i++)
    {
        int min = i;

        for( j=i+1 ; j<taille ; j++)
        {
            if( Tab[j] < Tab[min] )
            {
                min = j;
            }
        }

        if ( min != i)
        {
            echanger(Tab , min , i);
        }
    }
}


void triFusion(int* Tab , int taille)
{
    triFusionRec(Tab, 0, taille);
}

void triFusionRec(int* Tab , int d , int taille)
{
    if (taille - d > 1)
    {
        int mil = (d + taille) / 2;

        triFusionRec(Tab, d, mil);  // de d (inclus) à mil (exclus)
        triFusionRec(Tab, mil, taille);  // de mil (inclus) à f (exclus)
        fusion(Tab, d, mil, taille);     // Fusion de début (inclus) à mil (exclus) et de mil (inclus) à f (exclus)
    }
}

void fusion(int* Tab , int d , int mil, int f)
{
    //Déclaration des tableau
    int tailleL= mil - d;
    int L[tailleL + 1];

    int tailleR = f - mil;
    int R[tailleR + 1];

    // Copie du premier sous-tableau de d à mil
    for( int i = 0 ; i < tailleL; i++)
    {
        L[i] = Tab[i + d];
    }

    //Copie du second sous-tableau de mil+1 a f
    for(int i = 0; i < tailleR; i++)
    {
        R[i] = Tab[i + mil];
    }

    // Sentinelles
    L[tailleL] = std::numeric_limits<int>::max();
    R[tailleR] = std::numeric_limits<int>::max();

    //Fusion des deux sous-tableaux
    int pl = 0;
    int pr = 0;

    for (int i = 0; i < tailleL + tailleR; i++)
    {
        if(L[pl] < R[pr])
        {
            Tab[i + d] = L[pl];
            pl++;
        }
        else
        {
            Tab[i + d] = R[pr];
            pr++;
        }
    }
}


void triPanier(int* Tab , int taille)
{
    //Calcule la taille du tableau compteur
    int taillTabTemp = Tab[0];

    for (int i=0 ; i<taille ; i++)
    {
        if ( Tab[i] > taillTabTemp )
        {
            taillTabTemp = Tab[i];
        }
    }
    taillTabTemp++;

    //création et initialisation du tableau compteur
    int* tabTemp = new int[taillTabTemp];

    for (int i=0 ; i < taillTabTemp ; i++)
    {
        tabTemp[i] = 0;
    }

    // Calcul la fréquence d'apparition de chaque valeur
    for (int i=0 ; i < taille ; i++)
    {
        tabTemp[ Tab[i] ]++;
    }

    // tri du tableau initial grace au tableau compteur
    int posIni = 0;
    for (int i=0 ; i < taillTabTemp ; i++)
    {
        for (int j=0 ; j < tabTemp[i] ; j++)
        {
            Tab[posIni] = i;
            posIni++;
        }
    }

    //destruction du tableau
    delete[] tabTemp;
}

void triRapide(int* Tab , int taille)
{
    std::cout << "Pivot choisi arbitrairement (premier élément du tableau)" << std::endl;
    triRapideRec(Tab, 0, taille-1);
}

void triRapideRec(int* T, int deb, int fin)
{
    if (deb < fin)
    {
        int pivot = T[deb];
        int inf = deb + 1;
        int sup = fin;

        while (inf <= sup)
        {
            if (T[inf] <= pivot)
            {
                inf++;
            }
            else
            {
                int echange = T[inf];
                T[inf] = T[sup];
                T[sup] = echange;
                sup--;
            }
    }

    int echange = T[deb];
    T[deb] = T[sup];
    T[sup] = echange;

    triRapideRec(T, deb, sup - 1);
    triRapideRec(T, sup + 1, fin);
    }
}
