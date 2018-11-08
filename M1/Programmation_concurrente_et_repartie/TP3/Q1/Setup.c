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

    *memoryAddress = NB_PLACES;

    // Attente
    char *input;
    do
    {
        printf("Entrez n'importe quoi pour quitter \n");
        scanf("%s", &input);
    } while (input != NULL);

    // Détachement de la mémoire partagée
    int error = shmdt((void *)memoryAddress);
    if (error == -1)
    {
        perror("Detaching from memory");
        return 1;
    }

    // Destruction de la mémoire partagée
    error = shmctl(memoryId, IPC_RMID, NULL);
    if (error == -1)
    {
        perror("Destroying the shared memory");
        return 1;
    }

    return 0;
}