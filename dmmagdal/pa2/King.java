// King.java

class King extends ChessPiece{

	public King(){
		super();
	}

	public King(int x, int y, int color){
		super(x, y, color);
	}

	/*
	boolean isAttacking(int x, int y){
		if (Board[x+1][y] != "-"){
			return true;
		}
		else if (Board[x-1][y] != "-"){
			return true;
		}
		else if (Board[x][y+1] != "-"){
			return true;
		}
		else if (Board[x][y-1] != "-"){
			return true;
		}
		else if (Board[x+1][y+1] != "-"){
			return true;
		}
		else if (Board[x+1][y-1] != "-"){
			return true;
		}
		else if (Board[x-1][y+1] != "-"){
			return true;
		}
		else if (Board[x-1][y-1] != "-"){
			return true;
		}
		else{
			return false;
		}
	}*/
}
