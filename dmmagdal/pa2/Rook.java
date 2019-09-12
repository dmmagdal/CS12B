// Rook.java

class Rook extends ChessPiece{
	
	public Rook(){
		super();
	}

	public Rook(int x, int y, int color){
		super(x, y, color);
	}

	/*
	boolean isAttacking(int x, int y){
		for (int i = 0; i < size; i++){
			// row check
			if (Board[x][i] != "-"){
				return true;
			}
			// col check
			if (Board[i][y] != "-"){
				return true;
			}
		}
		return false;
	}*/
}
