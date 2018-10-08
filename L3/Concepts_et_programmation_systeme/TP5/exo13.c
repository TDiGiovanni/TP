#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>

int main(int argc, char** argv) {
  FILE* desc= fopen(argv[1],"r+");

  fputs("Avant le fork. \n",desc);
  
  fork();

  fputs("Après le fork. \n",desc);
  
  fclose(desc);
  
  return 0;
}
