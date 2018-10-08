#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char** argv) {
  for (int i=0; i<134; i++)
    printf("%s \n",strerror(i));

  return 0;
}
