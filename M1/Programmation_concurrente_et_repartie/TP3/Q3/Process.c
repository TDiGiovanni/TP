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

  // Récupération de la mémoire partagée
  int *shmId = shmget(key, sizeof(int), IPC_CREAT | 0777);
  if (shmId == -1)
  {
    perror("Creating shared memory");
    return 1;
  }

  // Attachement à la mémoire partagée
  int *memoryAddress = (int *)shmat(shmId, NULL, 0);
  if (memoryAddress == -1)
  {
    perror("Attaching to memory");
    return 1;
  }

  //TODO

  // Détachement de la mémoire partagée
  int error = shmdt((void *)memoryAddress);
  if (error == -1)
  {
    perror("Detaching from memory");
    return 1;
  }

  return 0;
}
