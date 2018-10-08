#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int isInPath (char** arge) {
  int i=0; int flag = 0;
  
  while (arge[i] != NULL && flag==0) {
    if (arge[i]==strstr(arge[i],"PATH"))
      flag=1;
    else
      i++;
  }

  char* chaine = arge[i]+5;
  char* chemin= strtok(chaine,":");
  flag = 0;

  while (flag==0 && chemin != NULL) {
    if (strcmp(chemin,".") || strcmp(chemin,get_current_dir_name()))
      flag = 1;
    else
      chemin=strtok(NULL,":");
  }

  return flag;
}

int main (int argc, char** argv, char** arge) {
  if (isInPath(arge))
    printf("Le répertoire courant fait partie des répertoires d'exécution. \n");
  else
    printf("Le répertoire courant ne fait pas partie des répertoires d'exécution. \n");

  return 0;
}
