// Bishop.java

class Bishop extends ChessPiece{
	
	void Bishop(int x, int y){
		x = col;
		y = row;
	}

	boolean isAttacking(int x, int y, int size, char[][] Board){
		// right diagonal{
		for (int j = 1; x+j < size; j++){
			for (int k = 0; k+y < size; k++){
				if (Board[j][k] != '-'){
					return true;
				}
			}
			for (int l = 0; y-1 > -1; l++){
				if (Board[j][l] != '-'){
					return true;
				}
			}
		}
		// left diagonal
		for (int m = 1; x-m > -1; m++){
			for (int n = 0; n+y < size; n++){
				if (Board[m][n] != '-'){
					return true;
				}
			}
			for (int o = 0; y-o > -1; o++){
				if (Board[m][o] != '-'){
					return true;
				}
			}
		}
		return false;
	}
}
