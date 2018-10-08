#include <stdio.h>


int main (int argc, char** argv, char** env)
{
  float a, b, c, d, e;

  printf("Saisissez 5 flottants: \n");
  scanf("%f", &a);
  scanf("%f", &b);
  scanf("%f", &c);
  scanf("%f", &d);
  scanf("%f", &e);

  float moy= (a+b+c+d+e)/5;
  printf("La moyenne est %f \n", moy);
    
  return 0;
}
