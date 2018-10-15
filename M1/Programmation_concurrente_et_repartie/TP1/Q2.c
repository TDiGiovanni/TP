#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "calcul.h"

int globalSum = 0;
pthread_mutex_t lockGlobalSum = PTHREAD_MUTEX_INITIALIZER;

// Paramètres de produit
struct argsProduit {
  int v1, v2;
} typedef argsProduit;

// Produit de v1 et v2 dans r
void* produit(void* p_args) {
  struct argsProduit* args = (struct argsProduit*)p_args;
  int v1 = args->v1;
  int v2 = args->v2;

  pthread_mutex_lock(&lockGlobalSum);
  printf("Adding result to sum... \n");
  globalSum += v1*v2;
  printf("Result added. \n");
  pthread_mutex_unlock(&lockGlobalSum);

  pthread_exit(NULL);
}

int main(int argc, char** argv) {
  srand(time(NULL));

  int n = 3;
  pthread_t idThread[n];
  struct argsProduit args[n];
  int v1[n], v2[n], r[n];
  
  // Initialisation des vecteurs et création des n threads
  for (int i = 0; i < n; i++) {
    v1[i] = rand()%10;
    v2[i] = rand()%10;
    printf("v1[%i] = %i - v2[%i] = %i \n",i,v1[i],i,v2[i]);

    args[i].v1 = v1[i];
    args[i].v2 = v2[i];
    if (pthread_create(&idThread[i], NULL, produit, &args[i]) != 0) {
      printf("Erreur création thread. \n");
      return 1;
    }
  }

  for (int i = 0; i < n; i++)
    pthread_join(idThread[i],NULL);

  printf("Result : %i \n",globalSum);
  
  return 0;
}
