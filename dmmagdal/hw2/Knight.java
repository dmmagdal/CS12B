// Knight.java

class Knight extends ChessPiece{
	
	void Knight(int x, int y){
		x = col;
		y = row;
	}

	boolean isAttacking(int x, int y, int size, char[][] Board){
		if (Board[x+2][y+1] != '-'){
			return true;
		}
		else if (Board[x+2][y-1] != '-'){
			return true;
		}
		else if (Board[x-2][y+1] != '-'){
			return true;
		}
		else if (Board[x-2][y-1] != '-'){
			return true;
		}
		else if (Board[x+1][y+2] != '-'){
			return true;
		}
		else if (Board[x+1][y-2] != '-'){
			return true;
		}
		else if (Board[x-1][y+2] != '-'){
			return true;
		}
		else if (Board[x-1][y-2] != '-'){
			return true;
		}
		else{
			return false;
		}
	}
}
