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
    int error = msgrcv(queueId, &operation, (size_t)(sizeof(operation)), 2, 0); // Réception du message dans la file
    if (error == -1) {
      printf("%s \n", strerror(errno));
      return 1;
    }

    printf("Réception de l'opération %f - %f \n", operation.operande1, operation.operande2);
    operation.result = operation.operande1 - operation.operande2;
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
