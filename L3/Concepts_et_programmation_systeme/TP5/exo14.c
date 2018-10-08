#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>

int main(int argc, char** argv) {
  FILE* desc1= fopen(argv[1],"r+");
  FILE* desc2= fopen(argv[1],"r+");

  fputs("Premier descripteur. \n",desc1);
  fputs("Second descripteur. \n",desc2);
  
  fclose(desc1);
  fclose(desc2);
  
  return 0;
}
