#include "Headers.c"

// Décompose un nombre en deux nombres premiers
// Renvoie 0 si terminé correctement, 1 sinon
int decompose()
{
  key_t key = ftok("./Key.txt", 'a'); // Récupération de la clé
  if (key == -1)
  {
    perror("Creating key");
    return 1;
  }

  int queueId = msgget(key, IPC_CREAT | 0666); // Récupération de l'ID de la file de messages

  struct NumberToDecompose number, divider;

  while (1)
  {
    // Réception d'un nombre à décomposer dans la file
    int error = msgrcv(queueId, &number, (size_t)(sizeof(NumberToDecompose)), 2, 0);
    if (error == -1)
    {
      perror("Receiving message");
      return 1;
    }

    printf("Décomposition de %i... \n", number.value);

    divider.isPrime = 2;
    divider.value = 2;

    while (number.value != divider.value && number.value % divider.value != 0)
    { // On recherche le premier diviseur du nombre à décomposer
      divider.value++;
    }

    if (number.value == divider.value)
    { // Si son premier diviseur est lui-même (donc premier)
      number.isPrime = 1;

      // Envoi du nombre premier dans la file
      int error = msgsnd(queueId, &number, (size_t)(sizeof(NumberToDecompose)), 0);
      if (error == -1)
      {
        perror("Sending message");
        return 1;
      }

      printf("%i est premier ! \n", number.value);
    }
    else
    { // Sinon
      number.value = number.value / divider.value;

      // Envoi des deux nouveaux nombres à décomposer dans la file
      int error = msgsnd(queueId, &number, (size_t)(sizeof(NumberToDecompose)), 0);
      if (error == -1)
      {
        perror("Sending message");
        return 1;
      }

      error = msgsnd(queueId, &divider, (size_t)(sizeof(NumberToDecompose)), 0);
      if (error == -1)
      {
        perror("Sending message");
        return 1;
      }

      printf("Décomposé en %i et %i. \n", number.value, divider.value);
    }
  }

  return 0;
}


int main(int argc, char **argv)
{
  srand(time(NULL));

  int nbChildren;
  printf("Entrez le nombre de processus enfant voulu : \n");
  scanf("%i", &nbChildren);

  key_t key = ftok("./Key.txt", 'a'); // Récupération de la clé
  if (key == -1)
  {
    perror("Creating key");
    return 1;
  }

  int queueId = msgget(key, IPC_CREAT | 0666); // Récupération de l'ID de la file de messages

  struct NumberToDecompose number;
  number.isPrime = 2;
  number.value = rand() % 1000;

  // Envoi du nombre dans la file
  int error = msgsnd(queueId, &number, (size_t)(sizeof(number)), 0);
  if (error == -1)
  {
    perror("Sending message");
    return 1;
  }

  printf("Décomposition de %i en nombre premiers : \n", number.value);

  for (int i = 0; i < nbChildren; i++)
  { // Création de nbChildren processus enfants pour décomposer les nombres
    int pId = fork();
    if (pId == 0) // Si processus enfant
      return decompose();
  }

  int maxSize = 1, result = 1;
  int* results = malloc(maxSize * sizeof(int));
  int* newResults;
  struct NumberToDecompose tempNumber;
  while (result != number.value)
  {
    // Réception d'un nombre premier dans la file
    error = msgrcv(queueId, &tempNumber, (size_t)(sizeof(NumberToDecompose)), 1, 0);
    if (error == -1)
    {
      perror("Receiving message");
      return 1;
    }

    result *= tempNumber.value;
    results[maxSize - 1] = tempNumber.value;
    maxSize++;

    // Agrandissement de la taille du tableau
    newResults = realloc(results, maxSize * sizeof(int));
    results = newResults;
  }

  printf("Résultat : ");
  for (int i = 0; i < maxSize; i++)
    printf("%i * ", results[i]);
  printf("%i \n", results[maxSize - 1]);

  free(newResults);
  free(results);

  return 0;
}
