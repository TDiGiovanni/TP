#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <errno.h>
#include <string.h>
#include <time.h>

struct Operation {
  long typeOperation;
  /* 
  ** 1 -> +
  ** 2 -> -
  ** 3 -> *
  ** 4 -> /
  ** 5 -> résultat
  */
  double operande1, operande2, result;
} typedef Operation;