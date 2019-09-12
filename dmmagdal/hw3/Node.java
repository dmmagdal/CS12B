// Node class for the LinkedList ADT
class Node{
	public ChessPiece piece;
	public Node next;

	public Node(){
		this.piece = null;
		this.next = null;
	}

	public Node(char p, int x, int y){
		this.piece = null;
		boolean color = identifyColor(p);
		if(p == 'k' || p == 'K') {
        	this.piece = new King(x, y, color);
  		}
	    else if(p == 'q' || p == 'Q') {
        	this.piece = new Queen(x, y, color);
    	}
    	else if(p == 'r' || p == 'R') {
        	this.piece = new Rook(x, y, color);
    	}
    	else if(p == 'b' || p == 'B') {
        	this.piece = new Bishop(x, y, color);
    	}
    	else if(p == 'n' || p == 'N') {
        	this.piece = new Knight(x, y, color);
    	}
    	else if(p == 'p' || p == 'P') {
        	this.piece = new Pawn(x, y, color);
    	}
	}

	public ChessPiece getChessPiece(){
		return this.piece;
	}

	public Node getNext(){
		return this.next;
	}

	public void setNext(Node next){
		this.next = next;
	}

	public boolean identifyColor(char p){
		if(p == 'k' || p == 'q' || p == 'r' || p == 'b' || p == 'n' || p == 'p') {
      		return true;
    	}
    	return false;
	}

	public boolean getColor(){
		return this.piece.getColor();
	}

	public int getx(){
		return this.piece.getx();
	}

	public int gety(){
		return this.piece.gety();
	}

	public void setx(int x){
		this.piece.setx(x);
	}

	public void sety(int y){
		this.piece.sety(y);
	}
}