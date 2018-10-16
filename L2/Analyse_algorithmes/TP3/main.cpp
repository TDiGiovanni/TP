#include <iostream>
#include "TriOutilsSimples.hpp"
#include "tris.hpp"


void afftri(int taille , std::string nomtri , void (*foncTri)(int*,int))
{
    //génération d tableu
    int* Tab = new int[taille];
    genererRandom(Tab , taille , 100);

    //affichage détaillé
    std::cout << std::endl << "====== Tri " << nomtri << " ======" << '\n';

    std::cout << "Tableau avant le tri : ";
    imprimer(Tab , taille);

    foncTri(Tab , taille);

    std::cout << "Tableau aprés le tri : ";
    imprimer(Tab , taille);
    std::cout << std::endl;

    delete[] Tab;

}

int main()
{
    // nettoye le temrinal
    system("clear");

    std::cout << "Question : " << std::endl;
    std::cout << "     1 - Test de tous les tris sur un tableau de 10 éléments." << std::endl << std::endl;

    int taille = 10;
    afftri(taille,"insertion",triInsertion);
    afftri(taille,"triBulle",triInsertion);
    afftri(taille,"Selection",triSelection);
    afftri(taille,"Fusion",triFusion);
    afftri(taille,"Panier",triPanier);
    afftri(taille,"Rapide",triRapide);

return 0;
}

/*
ordre de compilation : g++ TriOutilsSimples.cpp tris.cpp main.cpp -o tri
Ordre d'ex�cution : ./tri
*/
