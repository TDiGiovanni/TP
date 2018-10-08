#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <dirent.h>
#include <sys/types.h>
#include <sys/stat.h>

// Parcours récursif d'un répertoire
void parcours(char* env) {
  DIR* rep;
  rep=opendir(env);
  if (rep == -1)
    printf("Erreur lors de l'ouverture du répertoire. \n");

  char nomFic[256]= {};
  struct dirent* fic;
  struct stat info;

  //printf("Dans le répertoire %s : \n", env);
  
  while (fic=readdir(rep)) {
    strcpy(nomFic,env);
    strcat(nomFic,"/");
    strcat(nomFic,fic->d_name);
    
    if (lstat(nomFic,&info) == -1)
      printf("Erreur dans la récupération des informations du fichier %s. \n", fic->d_name);
    
    else {
      if (S_ISDIR(info.st_mode)
	  && strcmp(fic->d_name,".")!=0
	  && strcmp(fic->d_name,"..")!=0)
	parcours(nomFic);
      else
	if (strcmp(fic->d_name,".")!=0
	    && strcmp(fic->d_name,"..")!=0)
	  printf("N° inode : %d   Type : %d   Droits : .   Nom : %s \n", fic->d_ino, info.st_mode, fic->d_name);
    }
  }

  closedir(rep);
}


int main(int argc, char** argv) {
  parcours(argv[1]);
  
  return 0;
}
