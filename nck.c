#include <stdlib.h>
#include <stdio.h>
#include <limits.h>

unsigned long long nck(unsigned long long n, unsigned long long k) {
  if (k == 1) {
    return n;
  } else if (k == 0 || n == k) {
    return 1;
  } else {
    return (n * nck(n - 1, k - 1)) / k;
  }
}

int main(int argc, char *argv[]) {
  printf("%d\n", argc);
  //printf("%s\n", argv[0]);

  printf("N: %s\n", argv[1]);
  printf("K: %s\n", argv[2]);

  char *ptr1;
  char *ptr2;

  unsigned long long n = strtol(argv[1], &ptr1, 10);
  unsigned long long k = strtol(argv[2], &ptr2, 10);

  printf("NcK: %llu\n", nck(n, k));
  printf("MAX: %lu\n", ULONG_MAX);
}
