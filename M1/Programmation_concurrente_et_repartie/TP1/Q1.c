#include <stdio.h>
#include <pthread.h>
#include "calcul.h"

void* thread1(void* pa) {
  int* a = (int*)pa;
  
  printf("thread1.1 \n");
  calcul(1);
  printf("thread1.2 \n");

  (*a)++;
  
  pthread_exit(NULL);
}

void* thread2(void* pa) {
  int* a = (int*)pa;
  
  printf("thread2 \n");

  (*a)++;
  
  pthread_exit(NULL);
}

int main(int argc, char** argv) {
  pthread_t idT1, idT2;
  int a = 0;

  if (pthread_create(&idT1, NULL, thread1, &a) != 0) {
    printf("Erreur création thread. \n");
    return 1;
  }

  if (pthread_create(&idT2, NULL, thread2, &a) != 0) {
    printf("Erreur création thread. \n");
    return 1;
  }

  pthread_join(idT1,NULL);
  pthread_join(idT2,NULL);

  printf("a = %i \n", a);
  
  return 0;
}
