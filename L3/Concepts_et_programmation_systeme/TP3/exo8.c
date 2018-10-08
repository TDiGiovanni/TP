#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>


void copie(char* source, char* destination) {
  int src= open(source,O_RDONLY);
  if (src<0) {
    printf("Problème lors de l'ouverture du fichier source.");
    return;
  }
  
  int dst= open(destination,O_WRONLY);
  if (dst<0) {
    printf("Problème lors de l'ouverture du fichier destination.");
    return;
  }
  
  char c;
  while (read(src,&c,1)>0)
    write(dst,&c,1);

  close(src);
  close(dst);
}
  
int main (int argc, char** argv) {
  copie(argv[1],argv[2]);
  
  return 0;
}
