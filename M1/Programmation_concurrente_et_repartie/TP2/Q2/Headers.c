#include <errno.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <sys/types.h>
#include <time.h>
#include <unistd.h>

struct NumberToDecompose {
    long isPrime; // 1 si nombre premier, 2 sinon
    int value;
} typedef NumberToDecompose;
