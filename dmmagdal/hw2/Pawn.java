// Pawn.java

class Pawn extends ChessPiece{
	
	void Pawn(int x, int y){
		x = col;
		y = row;
	}

	boolean isAttacking(int x, int y, int size, char[][] Board){
		// Note: this is only for one way, the "white" pawn moving "up"
		if (Board[x+1][y+1] != '-'){
			return true;
		}
		else if (Board[x-1][y+1] != '-'){
			return true;
		}
		return false;
	}
}
