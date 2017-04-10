// ChessPiece Superclass
class ChessPiece{
	public int x;
	public int y;
	public boolean color;

	public ChessPiece(){
		this.x = -1;
		this.y = -1;
		this.color = false;
	}

	public ChessPiece(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public ChessPiece(ChessPiece piece){
		this.x = piece.x;
		this.y = piece.y;
		this.color = piece.color;
	}

	public int getx(){
		return this.x;
	}

	public int gety(){
		return this.y;
	}

	public void setx(int x){
		this.x = x;
	}

	public void sety(int y){
		this.y = y;
	}

	public boolean getColor(){
		return this.color;
	}

	public boolean isAttacking(int x, int y){
		return false;
	}
}