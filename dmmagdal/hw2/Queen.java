// Queen.java

class Queen extends ChessPiece{
	
	void Queen (int x, int y){
		x = col;
		y = row;
	}

	boolean isAttacking(int x, int y, int size, char[][] Board){
		for (int i = 0; i < size; i++){
			if (Board[x][i] != '-'){ // row check
				return true;
			}
			if (Board[i][y] != '-'){ // col check
				return true;
			}
		}
		// right branch diagonal
		for (int j = 1; x+j < size; j++){
			for (int k = 0; k+y < size; k++){
				if (Board[j][k] != '-'){
					return true;
				}
			}
			for (int l = 0; y-l > -1; l++){
				if (Board[j][l] != '-'){
					return true;
				}
			}
		}
		// left branch diagonal
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
