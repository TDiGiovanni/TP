#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

#define n 3

int workDone = 0;
pthread_mutex_t lockWorkDone = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t doneWorking = PTHREAD_COND_INITIALIZER;

void* work() {
  sleep(rand()%3); // Travail à synchroniser ici
  
  pthread_mutex_lock(&lockWorkDone); // Lock quand on utilise la variable commune
  workDone++;
  
  printf("Tâche %lu terminée. En attente des autres tâches. \n", pthread_self());

  if (workDone == n) // Signal de condition remplie lors de la dernière tâche
    pthread_cond_broadcast(&doneWorking);

  while (workDone < n) {
    pthread_cond_wait(&doneWorking,&lockWorkDone); // Attente du signal
  }

  pthread_mutex_unlock(&lockWorkDone); // Unlock quand on a plus besoin de la variable commune
  
  printf("Tâches sychronisées. Suite du travail... \n");

  sleep(rand()%3);
  
  pthread_exit(NULL);
}

int main(int argc, char** argv) {
  srand(time(NULL));

  pthread_t idThread[n];

  for (int i = 0; i < n; i++) {
    if (pthread_create(&idThread[i], NULL, work, NULL) != 0) {
      printf("Erreur création thread. \n");
      return 1;
    }
  }

  for (int i = 0; i < n; i++)
    pthread_join(idThread[i],NULL);

  pthread_cond_destroy(&doneWorking);
  pthread_mutex_destroy(&lockWorkDone);

  printf("Toutes les tâches sont terminées. \n");
  
  return 0;
}
