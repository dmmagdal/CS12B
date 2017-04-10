// Rook.java

class Rook extends ChessPiece{
	
	void Rook(int x, int y){
		x = col;
		y = row;
	}

	boolean isAttacking(int x, int y, int size, char[][] Board){
		for (int i = 0; i < size; i++){
			// row check
			if (Board[x][i] != '-'){
				return true;
			}
			// col check
			if (Board[i][y] != '-'){
				return true;
			}
		}
		return false;
	}
}
