#include "Headers.c"

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

  // Récupération du tableau
  int semId = semget(key, 1, IPC_CREAT | 0777);
  if (semId == -1)
  {
    perror("Creating semaphore array");
    return 1;
  }

  // Affichage du nombre de places
  int nbPlaces = semctl(semId, 0, GETVAL);
  if (nbPlaces == -1)
  {
    perror("Controlling semaphore array");
    return 1;
  }
  printf("Nombre de places : %i \n", nbPlaces);

  struct sembuf operation;
  operation.sem_num = 0;
  operation.sem_op = -1;
  operation.sem_flg = SEM_UNDO;

  while (1)
  {
    printf("Attente d'une place disponible... \n");

    // On essaie d'enlever une place au compteur
    int error = semop(semId, &operation, 1);
    if (error == -1)
    {
      perror("Operation on semaphore array");
      return 1;
    }

    printf("Place disponible \n");
    printf("Impression ticket \n");

    // Affichage du nombre de places
    nbPlaces = semctl(semId, 0, GETVAL);
    if (nbPlaces == -1)
    {
      perror("Controlling semaphore array");
      return 1;
    }
    printf("Nombre de places restantes : %i \n", nbPlaces);

    sleep(2); // On simule l'arrivée d'une voiture toutes les 2 secondes
  }

  return 0;
}
