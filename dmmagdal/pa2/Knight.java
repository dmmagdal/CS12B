// Knight.java

class Knight extends ChessPiece{
	
	public Knight(){
		super();
	}

	public Knight(int x, int y, int color){
		super(x, y, color);
	}

	/*
	boolean isAttacking(int x, int y){
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
	}*/
}
