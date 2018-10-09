#include "Operation.c"

int main(int argc, char** argv) {
  key_t key = ftok("./Key.txt", 'a');
  if (key == -1) { // Récupération de la clé
    printf("%s \n", strerror(errno));
    return 1;
  }

  int queueId = msgget(key, IPC_CREAT|0666); // Récupération de l'ID de la file de messages
  
  struct Operation operation;

  while (1) {
    // Réception du message dans la file
    int error = msgrcv(queueId, &operation, (size_t)(sizeof(operation)), 0, 0);
    if (error == -1) {
      printf("%s \n", strerror(errno));
      return 1;
    }

    switch (operation.typeOperation) {
    case 1:
      printf("Réception de l'opération %f + %f \n", operation.operande1, operation.operande2);
      operation.result = operation.operande1 + operation.operande2;
      break;
    case 2:
      printf("Réception de l'opération %f - %f \n", operation.operande1, operation.operande2);
      operation.result = operation.operande1 - operation.operande2;
      break;
    case 3:
      printf("Réception de l'opération %f * %f \n", operation.operande1, operation.operande2);
      operation.result = operation.operande1 * operation.operande2;
      break;
    case 4:
      printf("Réception de l'opération %f / %f \n", operation.operande1, operation.operande2);
      operation.result = operation.operande1 / operation.operande2;
      break;
    }

    operation.typeOperation = 5;
    printf("Envoi du résultat \n");

    // Envoi du résultat dans la file
    error = msgsnd(queueId, &operation, (size_t)(sizeof(operation)), 0);
    if (error == -1) {
      printf("%s \n", strerror(errno));
      return 1;
    }
  }

  return 0;
}
