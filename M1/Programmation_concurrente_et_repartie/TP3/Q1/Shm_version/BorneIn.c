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

  // Récupération de l'ID
  int memoryId = shmget(key, sizeof(int), IPC_CREAT | 0777);

  // Attachement à la mémoire partagée
  int *memoryAddress = (int *)shmat(memoryId, NULL, 0);
  if (memoryAddress == -1)
  {
    perror("Attaching to memory");
    return 1;
  }

  printf("Nombre de places : %i \n", *memoryAddress);
  while (1)
  {
    if (*memoryAddress > 0)
    {
      printf("Demande acceptée \n");
      (*memoryAddress)--;
      printf("Impression ticket \n");
      printf("Nombre de places restantes : %i \n", *memoryAddress);
    }
    else
      printf("Pas de place disponible \n");

    sleep(2); // On simule l'arrivée d'une voiture toutes les 2 secondes
  }

  // Détachement de la mémoire partagée
  int error = shmdt((void *)memoryAddress);
  if (error == -1)
  {
    perror("Detaching from memory");
    return 1;
  }

  return 0;
}
