#include "Headers.h"

int main(int argc, char **argv)
{
    srand(time(NULL));

    // Création de la clé
    key_t key = ftok("./Key.txt", 'a');
    if (key == -1)
    {
        perror("Creating key");
        return 1;
    }

    // Création de la mémoire partagée
    int* shmId = shmget(key, sizeof(int), IPC_CREAT | 0777);
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

    *memoryAddress = ;

    printf("Mémoire partagée mise en place \n");

    // Attente
    char *input;
    do
    {
        printf("Entrez n'importe quoi pour quitter (cela libérera la mémoire) \n");
        scanf("%s", input);
    } while (input == NULL);

    // Détachement de la mémoire partagée
    int error = shmdt((void *)memoryAddress);
    if (error == -1)
    {
        perror("Detaching from memory");
        return 1;
    }

    // Destruction de la mémoire partagée
    error = shmctl(shmId, IPC_RMID, NULL);
    if (error == -1)
    {
        perror("Destroying shared memory");
        return 1;
    }

    return 0;
}