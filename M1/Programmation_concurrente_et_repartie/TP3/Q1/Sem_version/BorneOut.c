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

  struct sembuf operation;
  operation.sem_num = 0;
  operation.sem_op = 1;
  operation.sem_flg = SEM_UNDO;

  while (1)
  {
    int error = semop(semId, &operation, 1);
    if (error == -1)
    {
      perror("Operation on semaphore array");
      return 1;
    }

    printf("Demande acceptée \n");
    printf("byebye \n");

    sleep(5); // On simule la sortie d'une voiture toutes les 5 secondes
  }

  return 0;
}
