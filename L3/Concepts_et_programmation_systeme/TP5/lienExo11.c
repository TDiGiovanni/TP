#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>

int main(int argc, char** argv) {
  FILE* desc= fopen(argv[1],"r+");

  fputs("Avant le changement des droits. \n",desc);

  chmod(argv[1],S_IRUSR|S_IXUSR|S_IRGRP|S_IXGRP|S_IROTH|S_IXOTH);

  fputs("Après le changement des droits. \n",desc);
  
  fclose(desc);
  
  return 0;
}
