#include <iostream>
#include "TriOutilsSimples.hpp"
#include "tris.hpp"


void afftri(int taille , std::string nomtri , void (*foncTri)(int*,int))
{
    //génération d tableu
    int Tab[taille];
    genererRandom(Tab , taille , 100);

    //affichage détaillé
    std::cout << std::endl << "====== Tri " << nomtri << " ======" << '\n';
    std::cout << "Tableau avant le tri : ";
    imprimer(Tab , taille);
    foncTri(Tab , taille);
    std::cout << "Tableau aprés le tri : ";
    imprimer(Tab , taille);

    std::cout << std::endl << std::endl;
}



int main()
{
    // nettoye le temrinal
    system("clear");

    // Affiche la liste des tris implémenté
    std::cout << "______________________________________" << std::endl << std::endl;
    std::cout << "Voici la liste des tris implémentés : " << std::endl << std::endl;
    std::cout << "      - tri insertion" << std::endl;
    std::cout << "      - tri bulle" << std::endl;
    std::cout << "      - tri par selection" << std::endl;
    std::cout << "      - tri fusion" << std::endl;
    std::cout << "      - tri rapide" << std::endl;
    std::cout << "      - tri panier" << std::endl;
    std::cout << "______________________________________" << std::endl << std::endl << std::endl;

    // affiche des question et exécution de celle choisie par l'utilisateur
    std::cout << "Question : " << std::endl << std::endl;
    std::cout << "     1 - Test de tous les tris sur un tableau de 10 éléments." << std::endl << std::endl;

    int question;
    do {
        std::cout << "Entrer le numéro de l'action que vous souhaitez réaliser : ";
        std::cin >> question;
    } while( question < 1 or question > 1);

    system("clear");

    switch (question)
     {
        case 1:
            int taille = 10;
            afftri(taille,"insertion",triInsertion);
            afftri(taille,"triBulle",triInsertion);
            afftri(taille,"Selection",triSelection);
            afftri(taille,"Fusion",triFusion);
            afftri(taille,"Panier",triPanier);
            afftri(taille,"Rapide",triRapide);

        break;
    }


return 0;
}

/*
ordre de compilation : g++ TriOutilsSimples.cpp tris.cpp main.cpp -o tri
Ordre d'ex�cution : ./tri
*/
