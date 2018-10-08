#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int dicho(char* fichier, char c) {
  int src= open(fichier,O_RDONLY);
  if (src<0) {
    printf("Erreur lors de l'ouverture du fichier. \n");
    return -1;
  }

  int deb= 0;
  int fin=lseek(src,0,SEEK_END);
  char k;

  while (deb<=fin) {
    int mid= (deb+fin)/2;
    lseek(src,mid,SEEK_SET);
    read(src,&k,1);

    if(c<k)
      fin=mid-1;
    if(c>k)
      deb=mid+1;
    if(c==k) {
      printf("Le caractère %c est en position %d. \n",c,mid);
      return mid;
    }
  }

  close(src);

  printf("Le caractère n'a pas été trouvé. \n");
  return -1;
}

int main (int argc, char** argv) {
  dicho(argv[1],argv[2][0]);

  return 0;
}
