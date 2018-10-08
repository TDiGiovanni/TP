#define TAILLE 4

typedef struct mm* mm;
struct mm {
  char secret[TAILLE+1];  // mot secret stocke dans une chaine de char
  int nbessais;			/* nombre d'essai */
};
/**
 * Cree un nouveau jeu en generant aleatoirement un nouveau mot secret
 * compose de TAILLE lettres comprises entre 0 et 9 toutes differentes
 */
mm mm_creer();
/**
 * Supprime un jeu en d�sallouant la m�moire
 */
void mm_detruire(mm);
/**
 * test un mot essai  face au mot secret stockÃ© dans le jeu
 *@returns un entier contenant (TAILLE+1)*nb lettres bien placees + nb lettres
 * mal placees. -1 si l'essai est erron� (nb lettres, ...)
 */
int mm_test(mm jeu, char* essai);
/** Retourne le nb d'essais d�j� effectu�s */
int mm_nbessais(mm jeu);

