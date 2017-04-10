// ChessPiece.java
// Create ChessPiece Superclass

class ChessPiece{
	public int x;
	public int y;
	public int color;

	public ChessPiece(){
		this.x = 0;
		this.y = 0;
		this.color = 0;
	}

	public ChessPiece(int x, int y, int color){
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public ChessPiece(ChessPiece piece){
		this.x = piece.x;
		this.y = piece.y;
		this.color = piece.color;
	}

	public boolean isAttacking(int x, int y){
		return false;
	}
}
