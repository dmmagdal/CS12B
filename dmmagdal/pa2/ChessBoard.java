// ChessBoard.java

class ChessBoard{

	private Node head;
	private int numItems;

	public ChessBoard(){
		head = null;
		numItems = 0;
	}


	public char findPiece(int xcoords, int ycoords){ // add exception for piece not found
		Node N = head;
		while (N != null){
			if (N.x == xcoords && N.y == ycoords){
				return N.p;
			}
			else{
				N = N.next;
			}
		}
		return '-';
	}

	public void insert(char p, int xcoords, int ycoords){ 
		Node N = new Node(p, xcoords, ycoords);
		N.next = head;
		head = N;
		numItems++;
	}

	public boolean isEqualNode(){
		Node N = head;
		Node Next = N.next;
		while (N != null){
			while (Next != null){
				if (N.x == Next.x && N.y == Next.y){
					return false;
				}
				Next = Next.next;
			}
			N = N.next;
		}
		return true;
	}

	public boolean kings(){
		int wking = 0;
		int bking = 0;
		Node N = head;
		while (N != null){
			if (N.p == 'k'){
				wking++;
			}
			else if (N.p == 'K'){
				bking++;
			}
			N = N.next;
		}
		if (wking == 1 && bking == 1){
			return true;
		}
		return false;
	}

	public boolean isAttacking(){
		Node N = head;
		Node Next = N.next;
		while (N != null){
			while (Next != null){
				if (N.piece.isAttacking(Next.x, Next.y)){
					return true;
				}
				Next = Next.next;
			}
			N = N.next;
		}
		return false;
	}
}
class Node{
	public Node next;
	public ChessPiece piece;
	public char p;
	public int x;
	public int y;

	public Node(){
		this.next = null;
		this.piece = null;
		this.p = '-';
		this.x = 0;
		this.y = 0;
	}

	public Node(char p, int xcoords, int ycoords){
		int color = 0; //0 is Black and 1 is White
		p = this.p;
		// switch statemens
		// initialze the proper class or piece in the case
		switch(p){
			case 'k':
				color = 1;
				piece = new King(xcoords, ycoords, color);
				break;
			case 'K':
				piece = new King(xcoords, ycoords, color);
				break;
			case 'q':
				color = 1;
				piece = new Queen(xcoords, ycoords, color);
				break;
			case 'Q':
				piece = new Queen(xcoords, ycoords, color);
				break;
			case 'r':
				color = 1;
				piece = new Rook(xcoords, ycoords, color);
				break;
			case 'R':
				piece = new Rook(xcoords, ycoords, color);
				break;
			case 'n':
				color = 1;
				piece = new Knight(xcoords, ycoords, color);
				break;
			case 'N':
				piece = new Knight(xcoords, ycoords, color);
				break;
			case 'b':
				color = 1;
				piece = new Bishop(xcoords, ycoords, color);
				break;
			case 'B':
				piece = new Bishop(xcoords, ycoords, color);
				break;
		}
		xcoords = x;
		ycoords = y;
		next = null;
	}
}