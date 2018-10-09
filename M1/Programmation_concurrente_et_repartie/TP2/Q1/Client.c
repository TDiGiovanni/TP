#include "Operation.c"

int main(int argc, char** argv) {
  srand(time(NULL));
  
  key_t key = ftok("./Key.txt", 'a'); // Récupération de la clé
  if (key == -1) {
    printf("%s \n", strerror(errno));
    return 1;
  }

  int queueId = msgget(key, IPC_CREAT|0666); // Récupération de l'ID de la file de messages

  struct Operation operation;
  operation.typeOperation = rand()%4 +1;
  operation.operande1 = rand()%100;
  operation.operande2 = rand()%100;

  char printType;
  switch (operation.typeOperation) {
    case 1:
      printType = '+';
      break;
    case 2:
      printType = '-';
      break;
    case 3:
      printType = '*';
      break;
    case 4:
      printType = '/';
      break;
    }

  printf("Envoi de l'opération %f %c %f... \n", operation.operande1, printType, operation.operande2);

  // Envoi du message dans la file
  int error = msgsnd(queueId, &operation, (size_t)(sizeof(operation)), 0);
  if (error == -1) {
    printf("%s \n", strerror(errno));
    return 1;
  }

  printf("Opération envoyée. En attente du résultat... \n");

  // Réception du résultat dans la file
  error = msgrcv(queueId, &operation, (size_t)(sizeof(operation)), 5, 0);
  if (error == -1) {
    printf("%s \n", strerror(errno));
    return 1;
  }

  printf("Résultat : %f \n", operation.result);
  
  return 0;
}
