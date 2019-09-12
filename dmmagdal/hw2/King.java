// King.java

class King extends ChessPiece{

	void King(int x, int y){
		x = col;
		y = row;
	}

	boolean isAttacking(int x, int y, int size, char[][] Board){
		if (Board[x+1][y] != '-'){
			return true;
		}
		else if (Board[x-1][y] != '-'){
			return true;
		}
		else if (Board[x][y+1] != '-'){
			return true;
		}
		else if (Board[x][y-1] != '-'){
			return true;
		}
		else if (Board[x+1][y+1] != '-'){
			return true;
		}
		else if (Board[x+1][y-1] != '-'){
			return true;
		}
		else if (Board[x-1][y+1] != '-'){
			return true;
		}
		else if (Board[x-1][y-1] != '-'){
			return true;
		}
		else{
			return false;
		}
	}
}
