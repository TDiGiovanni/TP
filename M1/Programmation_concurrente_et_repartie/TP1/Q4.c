#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include "calcul.h"

#define NB_THREADS 3
#define NB_ZONES 5

struct paramsActivite {
  int numActivite;
} typedef paramsActivite;

int d[NB_THREADS];
pthread_mutex_t lockD = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t workDone = PTHREAD_COND_INITIALIZER;

void* activite(void* parametres) {
  struct paramsActivite* pa = (struct paramsActivite*)parametres;
  int numActivite = pa->numActivite;
  int currentZone = 0;
  pthread_mutex_lock(&lockD);
  d[numActivite] = currentZone;
  pthread_mutex_unlock(&lockD);

  while (currentZone < NB_ZONES) {
    pthread_mutex_lock(&lockD);
    for (int i = 0; i < numActivite; i++)
      while (d[i] <= currentZone) {
        pthread_cond_wait(&workDone,&lockD);
      }
    pthread_mutex_unlock(&lockD);
    
    printf("Traitement de la zone %i par l'activité %i... \n", currentZone+1, numActivite+1);
    calcul(rand() % 3); // Traitement de l'image
    printf("Zone %i traitée par l'activité %i. \n", currentZone+1, numActivite+1);

    currentZone++;
    pthread_mutex_lock(&lockD);
    d[numActivite] = currentZone;
    pthread_mutex_unlock(&lockD);
    pthread_cond_broadcast(&workDone);
  }
    
  pthread_exit(NULL);
}

int main(int argc, char** argv) {
  srand(time(NULL));
  
  int zones[NB_ZONES];
  pthread_t idThread[NB_THREADS];
  struct paramsActivite parametres[NB_THREADS];

  for (int i = 0; i < NB_ZONES; i++)
    zones[i] = rand() % 100; // Initialisation des zones

  for (int i = 0; i < NB_THREADS; i++) {
    d[i] = -1;

    parametres[i].numActivite = i;
    if (pthread_create(&idThread[i], NULL, activite, &parametres[i]) != 0) {
      printf("Erreur lors de la création de thread. \n");
      return 1;
    }
  }

  for (int i = 0; i < NB_THREADS; i++)
    pthread_join(idThread[i],NULL);

  printf("Toutes les zones ont été traitées par toutes les activitées. \n");

  return 0;
}
