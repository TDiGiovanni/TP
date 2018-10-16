#include <stdio.h>
#include <stdlib.h>
#include "pair.h"
#include "impair.h"


int main (int argc, char** argv)
{
  int n= atoi(argv[1]);

  if ( pair(n) )
    printf("n est pair! \n");
  else
    printf("n est impair! \n");

  return 0;
}
