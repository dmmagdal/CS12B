// lrc.c
// play game left, right, center

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

typedef enum faciem{
	left, right, center, pass
} faces;


// void roll(int player, int *pot, int[] *money, int playernum, char[] *names);

int nextleft(int player, int[] money, int playernum);

int nextright(int player, int[] money, int playernum);


int main(){
	faces die[] = {left, right, center, pass, pass, pass};
	const char *names[] = {"Whoopi", "Dale", "Rosie", "Jimmie", "Barbara", "Kyle", "Raven", "Tony", "Jenny", "Clint"};
	int money[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
	int seed, playernum;

	printf("Random seed: \n");
	scanf("%d", &seed);
	printf("How many players? \n");
	scanf("%d", &playernum);

	int pot = 0; // contains value of pot
	int playercounter = playernum; // this counter keeps track of how many players are playing
	int player = 0;
	while (playercounter != 1){ // run game until their is only one player (the winner)
		// roll on player 1 and go
		if (money[player] == 0){ // skips if the player we're on has no money
			player++;
		}
		else if (player > playernum){ // reset back to the "beginning" player
			player = 0;
		}
		else{
			if (money[player] == 1){
				printf("%c rolls ...", *names[player]);
				// roll(player, *pot, *money, playernum, *names);
				int s = rand()%6;
				if (money[player] == 0){
					break;
				}
				else{
					if (s == 0){	// left
						int k = nextleft(player, *money, playernum);
						money[k]++;
						money[player]--;
						printf(" gives $1 to %c" *names[k]);
					}
					else if (s == 1){	// right
						int j = nextright(player, *money, playernum);
						money[j]++;
						money[player]--;
						printf(" gives $1 to %c" *names[j]);
					}
					else if (s == 2){ // center
						pot++;
						money[player]--;
						printf(" puts $1 in the pot");
					}
					else{
						printf(" gets a pass");
					}
				}
				printf("\n");
				if (money[player] == 0){
					playercounter--;
				}
			}
			else if (money[player] == 2){
				printf("%c rolls ...", *names[player]);
				// roll(player, *pot, *money, playernum, *names);
				// roll(player, *pot, *money, playernum, *names);
				for (int i = 0; i < 2; i++){
					int s = rand()%6;
					if (money[player] == 0){
						break;
					}
					else{
						if (s == 0){	// left
							int k = nextleft(player, *money, playernum);
							money[k]++;
							money[player]--;
							printf(" gives $1 to %c" *names[k]);
						}
						else if (s == 1){	// right
							int j = nextright(player, *money, playernum);
							money[j]++;
							money[player]--;
							printf(" gives $1 to %c" *names[j]);
						}
						else if (s == 2){ // center
							pot++;
							money[player]--;
							printf(" puts $1 in the pot");
						}
						else{
							printf(" gets a pass");
						}
					}
				}
				printf("\n");
				if (money[player] == 0){
					playercounter--;
				}
			}
			else { // if the player has 3 or more moneys
				printf("%c rolls ...", *names[player]);
				// roll(player, *pot, *money, playernum, *names);
				// roll(player, *pot, *money, playernum, *names);
				// roll(player, *pot, *money, playernum, *names);
				for (int i = 0; i < 3; i++){
					int s = rand()%6;
					if (money[player] == 0){
						break;
					}
					else{
						if (s == 0){	// left
							int k = nextleft(player, *money, playernum);
							money[k]++;
							money[player]--;
							printf(" gives $1 to %c" *names[k]);
						}
						else if (s == 1){	// right
							int j = nextright(player, *money, playernum);
							money[j]++;
							money[player]--;
							printf(" gives $1 to %c" *names[j]);
						}
						else if (s == 2){ // center
							pot++;
							money[player]--;
							printf(" puts $1 in the pot");
						}
						else{
							printf(" gets a pass");
						}
					}
				}
				printf("\n");
				if (money[player] == 0){
					playercounter--;
				}
			}
			player++;
		}
	}

	return 0;
}

/*
void roll(int player, int *pot, int[] *money, int playernum, char[] *names){
	int s = rand()%6;
	if (money[player] == 0){
		break;
	}
	else{
		if (s == 0){	// left
		money[nextleft(*player, *money, playernum)]++;
		money[player]--;
		printf(" gives $1 to %c" *names[nextleft(*player, *money, playernum)]);
	}
	else if (s == 1){	// right
		money[nextright(*player, *money, playernum)]++;
		money[player]--;
		printf(" gives $1 to %c" *names[nextright(*player, *money, playernum)]);
	}
	else if (s == 2){ // center
		pot++;
		money[player]--;
		printf(" puts $1 in the pot");
	}
	else{
		printf(" gets a pass");
	}
}

void roll(int player, int num, int *pot, int[] *money, int playernum){
	int s = rand()%6;
	if (num == 1){
		if (money[player-1] == 0){
			break;
		}
		else{
			if (s == 0){	// left
			money[nextleft(player, money)]++;
			money[player-1]--;
		}
		else if (s == 1){	// right
			money[nextright(player, money)]++;
			money[player-1]--;
		}
		else if (s == 2){ // center
			pot++;
			money[player-1]--;
		}
		else{

		}
	}
	else{
		if (s == 0){	// left
			money[nextleft(player, money)]++;
			money[player-1]--;
		}
		else if (s == 1){	// right
			money[nextright(player, money)]++;
			money[player-1]--;
		}
		else if (s == 2){ // center
			pot++;
			money[player-1]--;
		}
		else{

		}
		roll(player, num-1, pot, money, playernum);
	}
}
*/

int nextleft(int player, int[] money, int playernum){
	int i = player-1; // left of actual player
	while (i != player){
		if (i < 0){
			i = playernum-1;
		}
		if (money[i] == 0){
			i--;
		}
		else{
			return i;
		}
	}
}

int nextright(int player, int[] money, int playernum){
	int i = player+1; // right of actual player
	while (i != player){
		if (i > 0){
			i = 0;
		}
		if (money[i] == 0){
			i++;
		}
		else{
			return i;
		}
	}
}