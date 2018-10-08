#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>

int main(int argc, char**argv) {
  struct stat info;

  if (lstat(argv[1],&info)==-1)
    printf("Erreur \n");

  else {
    if (S_ISREG(info.st_mode))
      printf("%s est un fichier régulier. \n",argv[1]);
    
    if (S_ISDIR(info.st_mode))
      printf("%s est un répertoire régulier. \n",argv[1]);
    
    if (S_ISLNK(info.st_mode))
      printf("%s est un lien symbolique. \n",argv[1]);
  }
  
  return 0;
}
