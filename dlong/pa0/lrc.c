// lrc.c
// play game left, right, center

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

typedef enum faciem{
	left, right, center, pass
} faces;

int main(){
	faces die[] = {left, right, center, pass, pass, pass};
	const char *names[] = {"Whoopi", "Dale", "Rosie", "Jimmie", "Barbara", "Kyle", "Raven", "Tony", "Jenny", "Clint"};
	int seed, playernum;
	die D1;
	die D2;
	die D3;

	int rand = rand() % 4; //random int between 0 and 3

	printf("Random seed: \n");
	scanf("%d", &seed);
	printf("How many players? \n");
	scanf("%d", &playernum);

	// printf("seed: %d, playernum: %d\n", seed, playernum);



	return 0;
}
