#include <stdio.h>
#include <stdlib.h>

#define K 100
const int KBIS=100;
int tab[K];
static float f;

int main (int argc, char *argv[]) {
  {int i=1;int j=2;i=i+j;}
  int l;
  char*s[]={"un","deux"};
  static int j=2;
  int *td=(int*)malloc(5*sizeof(int));
  printf("nom \t taille\t valeur\t adresse\n");
  printf("%s \t %lu \t %d \t %p \n","l",sizeof(l),l,&l);
  printf("%s \t %lu \t %p \t %p \n","s",sizeof(s),s,&s);
  printf("%s \t %lu \t %p \t %p \n","s[0]",sizeof(s[0]),s[0],&(s[0]));
  printf("%s \t %lu \t %d \t %p \n","argc",sizeof(argc),argc,&argc);
  printf("%s \t %lu \t %d \t %p \n","KBIS",sizeof(KBIS),KBIS,&KBIS);
  printf("%s \t %lu \t %p \t %p \n","tab",sizeof(tab),tab,&tab);
  printf("%s \t %lu \t %d \t %p \n","tab[1]",sizeof(tab[1]),tab[1],&(tab[1]));
  printf("%s \t %lu \t %-5.2f \t %p \n","f",sizeof(f),f,&f);
  printf("%s \t %lu \t %d \t %p \n","j",sizeof(j),j,&j);
  printf("%s \t %lu \t %p \t %p \n","td",sizeof(td),td,&td);
  printf("%s \t %lu \t %d \t %p \n","td[0]",sizeof(td[0]),td[0],&(td[0]));
  int (*h)(int,char**)=main; /* pointeur sur fonction */
  printf("%s \t %lu \t %p \t %p \n","h",sizeof(h),h,&h);
}
