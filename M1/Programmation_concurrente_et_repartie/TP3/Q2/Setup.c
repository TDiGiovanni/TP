#include "Headers.c"

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

    // Création du tableau de sémaphores
    int semId = semget(key, 1, IPC_CREAT | 0777);
    if (semId == -1)
    {
        perror("Creating semaphore array");
        return 1;
    }

    int nbProcs;
    printf("Combien de processus ? \n");
    scanf("%i", &nbProcs);

    // Initialisation du tableau
    union semun init;
    init.val = nbProcs;
    int error = semctl(semId, 0, SETVAL, init);
    if (error == -1)
    {
        perror("Initialising semaphore array");
        return 1;
    }

    printf("Tableau de sémaphores mis en place \n");

    // Attente
    char *input;
    do
    {
        printf("Entrez n'importe quoi pour quitter (cela détruira le tableau) \n");
        scanf("%s", input);
    } while (input == NULL);

    // Destruction du tableau
    error = semctl(semId, 0, IPC_RMID);
    if (error == -1)
    {
        perror("Destroying semaphore array");
        return 1;
    }

    return 0;
}