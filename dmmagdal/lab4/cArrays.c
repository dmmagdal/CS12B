#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char* argv[]){
	int i, n;
	int* A;

	// Check number of command line arguments
	if (argc < 2){
		printf("Usage: %s positive_integer\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	// Check if command line argumen is an int and assigns it to n
	if (scanf(argv[1], "%d", &n) < 1 || n < 1){
		printf("Usage: %s positive_integer\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	A = calloc(n, sizeof(int));
	for (i = 0; i < n; i++){
		A[i] = 2*i+2;
	}

	for (i = 0; i < n; i++){
		printf("%d", *(A+i));
	}

	free(A);
	A = NULL;

	return EXIT_SUCCESS;
}
