#include "Headers.h"

int main(int argc, char **argv)
{
  srand(time(NULL));

  // Récupération de la clé
  key_t key = ftok("./Key.txt", 'a');
  if (key == -1)
  {
    perror("Creating key");
    return 1;
  }

  // Récupération du tableau de sémaphores
  int semId = semget(key, 1, IPC_CREAT | 0777);
  if (semId == -1)
  {
    perror("Creating semaphore array");
    return 1;
  }

  printf("Calcul... \n");
  sleep(2); //TODO
  printf("Calcul terminé. \n");

  struct sembuf operation;
  operation.sem_num = 0;
  operation.sem_op = -1;
  operation.sem_flg = SEM_UNDO;

  // On essaie d'enlever une place au compteur dès que notre processus est prêt
  int error = semop(semId, &operation, 1);
  if (error == -1)
  {
    perror("Operation on semaphore array");
    return 1;
  }

  // Affichage du nombre de processus à attendre
  int nbProcs, lastNbProcs = -1;
  do
  {
    nbProcs = semctl(semId, 0, GETVAL);
    if (nbProcs == -1)
    {
      perror("Controlling semaphore array");
      return 1;
    }

    if (nbProcs != lastNbProcs)
      printf("Attente de %i autres processus \n", nbProcs);

    lastNbProcs = nbProcs;
  } while (nbProcs != 0);

  printf("RDV terminé. Reprise du programme \n");

  /* On rajoute 1 au sémaphore maintenant que le RDV est passé
  operation.sem_op = 1;
  error = semop(semId, &operation, 1);
  if (error == -1)
  {
    perror("Operation on semaphore array");
    return 1;
  } */

  return 0;
}
