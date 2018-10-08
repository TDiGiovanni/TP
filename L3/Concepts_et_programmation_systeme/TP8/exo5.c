#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void crible (int* in) {
  close(in[1]);
  
  int p;
  if (read(in[0],&p,sizeof(p))!=0) {
    printf("%i \n",p);
    
    int out[2]; // Tube dans lequel on va écrire les nombres non multiples de p
    if (pipe(out) == -1) {
      printf("Erreur lors de l'ouverture du tube. \n");
      return;
    }

    int f=fork();
    if (f==0) { // Fils
      close(in[0]);
      crible(out); // Rappel de la fonction
    }
    else {
      if (f>0) { // Père
	close(out[0]);
	int i;
	while (read(in[0],&i,sizeof(i)))
	  if (i%p != 0) // Si i n'est pas multiple de p, on le garde
	    write(out[1],&i,sizeof(i));
	close(in[0]);
	close(out[1]);
      }
      else {
	printf("Erreur du fork. \n");
	return;
      }
    }
  }
}

int main(int argc, char** argv) {
  int n;
  printf("Entrez la valeur de n : ");
  scanf("%i",&n);
  
  int desc[2]; // 0 pour lecture, 1 pour écriture
  if (pipe(desc) == -1) {
    printf("Erreur lors de l'ouverture du tube. \n");
    return EXIT_FAILURE;
  }

  for (int i=2; i<=n; i++)
    write(desc[1],&i,sizeof(i)); // On remplit le tube des nombres de 2 à n

  crible(desc);
  
  return EXIT_SUCCESS;
}
