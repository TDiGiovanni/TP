#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define TEST_SECG(v,deb,fin,nb) while (nb--) {sommeEntiersConsecutifsGeneral##v(deb,fin);}

/* Fonctions de sommes d'entiers consécutif de 0 à n */
unsigned int sommeEntiersConsecutifsIteratif(unsigned int n) {
  unsigned int k=0;
  
  unsigned int i;
  for (i= 0; i<=n; i++)
    k+=i;

  return k;
}

unsigned int sommeEntiersConsecutifsRecursif(unsigned int n) {
  if (n==0)
    return 0;
  else
    return sommeEntiersConsecutifsRecursif(n-1)+n;
}

unsigned int sommeEntiersConsecutifsFormule(unsigned int n) {
  return n+(n+1)/2;
}

/* Fonctions de sommes d'entiers consécutifs de a à b */
unsigned int sommeEntiersConsecutifsGeneral1(unsigned int a, unsigned int b) { /* Version itérative */
  unsigned int k=0;
  
  unsigned int i;
  for (i= a; i<=b; i++)
    k+=i;

  return k;
}

unsigned int sommeEntiersConsecutifsGeneral2(unsigned int a, unsigned int b) { /* Version récursive */
  if (a>=b)
    return a;
  else
    return sommeEntiersConsecutifsGeneral2(a,b-1)+b;
}

unsigned int sommeEntiersConsecutifsGeneral3(unsigned int a, unsigned int b) { /* Version avec formule */
  return (a+b)*(b-a+1)/2;
}

unsigned int sommeEntiersConsecutifsGeneral4(unsigned int a, unsigned int b) { /* Version optimisée */
  if ((a&1) == (b&1)) /* On vérifie si a et b sont tous les deux pairs ou impairs */
    return ((a+b)>>1)*(b-a+1); /* >>1 -> décalage de 1bit vers la droite, donc /2 */
  else
    return (a+b)*((b-a+1)>>1);
      
}

/* Main */
int main (int argc, char** argv) {
  /*
  unsigned int n;
  */
  unsigned int a, b;
  unsigned int deb, fin, nb;
  clock_t temps;

  if (argc != 1 && argc != 5) { /* Si on a pas le bon nombre d'arguments */
    fprintf(stderr,"Erreur : entrez 1 (pour itératif), 2 (pour récursif), 3 (pour formule) ou 4 (pour optimisé) en 1er argument, puis la borne de départ de la somme, puis la borne de fin, puis le nombre de tests. \n");
    return 1;
  }

  if (argc == 5) {
    /* Conversion des char* en unsigned int */
    deb= strtoul(argv[2],NULL,0);
    fin= strtoul(argv[3],NULL,0);
    nb= strtoul(argv[4],NULL,0);

    temps= clock();
    
    switch (argv[1][0]) {
    case '1':
      printf("Test version itérative : \n");
      printf("Somme des entiers consecutifs de %u a %u = %u. \n",deb,fin,sommeEntiersConsecutifsGeneral1(deb,fin));
      TEST_SECG(1,deb,fin,nb);
      break;
      
    case '2':
      printf("Test version récursive : \n");
      printf("Somme des entiers consecutifs de %u a %u = %u. \n",deb,fin,sommeEntiersConsecutifsGeneral2(deb,fin));
      TEST_SECG(2,deb,fin,nb);
      break;
      
    case '3':
      printf("Test version avec formule : \n");
      printf("Somme des entiers consecutifs de %u a %u = %u. \n",deb,fin,sommeEntiersConsecutifsGeneral3(deb,fin));
      TEST_SECG(3,deb,fin,nb);
      break;
      
    case '4':
      printf("Test version optimisée : \n");
      printf("Somme des entiers consecutifs de %u a %u = %u. \n",deb,fin,sommeEntiersConsecutifsGeneral4(deb,fin));
      TEST_SECG(4,deb,fin,nb);
      break;
      
    default:
      fprintf(stderr,"Erreur : entrez 1 (pour itératif), 2 (pour récursif), 3 (pour formule) ou 4 (pour optimisé) en 1er argument, puis la borne de départ, puis la borne de fin puis le nombre d'itérations. \n");
      return 1;
      break;
    }

    printf("Temps : %f secondes. \n",(float)temps/(float)CLOCKS_PER_SEC);
  }

  if (argc == 1) {
    /*
    printf("Entrez un entier positif : \n");
    scanf("%u",&n);
    
    printf("Somme des entiers de 0 à %u : \n",n);
    printf("Iterativement : %u \n",sommeEntiersConsecutifsIteratif(n));
    printf("Recursivement : %u \n",sommeEntiersConsecutifsRecursif(n));
    */
    
    printf("Entrez deux entiers positifs a puis b, avec a <= b: \n");
    scanf("%u %u",&a,&b);

    printf("Somme des entiers de %u à %u : \n",a,b);
    printf("Iterativement : %u \n",sommeEntiersConsecutifsGeneral1(a,b));
    printf("Recursivement : %u \n",sommeEntiersConsecutifsGeneral2(a,b));
    printf("Avec formule : %u \n",sommeEntiersConsecutifsGeneral3(a,b));
    printf("Optimise : %u \n",sommeEntiersConsecutifsGeneral4(a,b));
  }
  
  return 0;
}
