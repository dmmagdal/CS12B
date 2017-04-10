// Chessmoves.java

import java.util.Scanner;
import java.io.*;

// LinkedList ADT
class ChessBoardADT{
	private static int boardize;
	private static Node head;
	private boolean val;
	private static Scanner in;
	//private static BufferedReader in;
	private static PrintWriter out;

	// constructor
	public ChessBoardADT(){
		head = new Node();
	}

	// return a node with coords x and y
	public Node findChessPiece(int x, int y){
		Node piece = head;
    	while(piece != null) {
      		if(piece.getx() == x && piece.gety() == y) {
        		return piece;
      		}
     		piece = piece.next;
    	}
    	return null;
	}

	// find a node, then change its x and y
	public void changeChessPiece(int x1, int y1, int x2, int y2){
		Node foundPiece = findChessPiece(x1, y1);
    	if (foundPiece != null) {
    		// if a piece is returned, change the x and y of the piece
      		foundPiece.setx(x2);
      		foundPiece.sety(y2);
    	}
   		
	}

	// check if movement is validMove
	public boolean validMove(int x1, int y1, int x2, int y2) throws NullPointerException{
		// if x and y is under the attack pattern
		if (findChessPiece(x1, y1).getChessPiece().isAttacking(x2, y2) == false){
			return false;
		}
		// if x and y are blocked 
		else if (isBlocked(x1, y1, x2, y2) == true){
			return false;
		}
		else {
			return true;
		}

	}

  	// check to see if movement is blocked
  	public boolean isBlocked(int x1, int y1, int x2, int y2){
  		Node N = head;
  		// scan all other pieces in the array
  		while (N.next != null){
  			// make sure our piece doesnt block itself
  			if (isDifferent(N, findChessPiece(x1, y1)) == false){
  				continue;
  			}
  			if (findChessPiece(x1, y1).getChessPiece().isAttacking(N.getx(), N.gety()) == true && N.getChessPiece().isAttacking(x2, y2) == true){
  				return true;
  			}
  			N = N.next;
  		}
  		return false;
  	}

  	// check for check
  	public char check(){
  		// return b, w, or -
  		Node N = head;
  		while (N.next != null){
  			if (isDifferent(N, findWKing('k')) == false || isDifferent(N, findBKing('K')) == false){
  				// prevent scanning the kings themselves 
  				continue;
  			}
  			if (N.getChessPiece().isAttacking(findWKing('k').getx(), findWKing('k').gety()) == true){
  				return 'w';
  			}
  			else if (N.getChessPiece().isAttacking(findBKing('K').getx(), findBKing('K').gety()) == true){
  				return 'b';
  			}
  			N = N.next;
  		}
  		return '-';
  	}

  	/*
  	// check for checkmate()
  	public char checkmate(){
  		
  	}
  	*/

  	// find the board's white king
  	public Node findWKing(char p){
  		Node N = head;
  		while (N.next != null){
  			if (N.getChessPiece() instanceof King){
  				if (N.identifyColor(p) == true){
  					return N;
  				}
  			}
  			N = N.next;
  		}
  		return null;
  	}

  	// find the board's black king
	public Node findBKing(char p){
  		Node N = head;
  		while (N.next != null){
  			if (N.getChessPiece() instanceof King){
  				if (N.identifyColor(p) == false){
  					return N;
  				}
  			}
  			N = N.next;
  		}
  		return null;
  	}

	// insert new node
	public Node insert(Node piece){
		Node temp = head.getNext();
		head.setNext(piece);
		piece.setNext(temp);
		return head;
	}

	// see if two nodes are different
	public boolean isDifferent(Node one, Node other) {
    	if(one.getx() == other.getx() && one.gety() == other.gety() && one.getColor() == other.getColor()) {
      		return false;
    	}
    	return true;
  	}	

  	/*
  	public boolean pieceDifferent(Node a, x, y){
		if (a.getx() == x && a.gety() ==y)
			return true
  	}

  	*/

  	//executes all operations
  	public static void Operate() throws IOException, NullPointerException{
  		int lineNum = 0;
		ChessBoardADT board = null;
		String line;
		int[] MoveSet;
		
		// for BufferedReader, use in.readLine()
		// for Scanner, use in.nextLine()
		while ((line = in.nextLine()) != null){
			String[] input = line.split(" ");
			if (lineNum % 2 == 0){
				board = new ChessBoardADT();
				boardize = Integer.parseInt(input[0]);
				for (int i = 1; i < input.length; i += 3){
					head = board.insert(new Node(input[i].charAt(0), Integer.parseInt(input[i+2]), Integer.parseInt(input[i+1])));
				}
			}
			else{
				MoveSet = new int[input.length];
				for (int i = 0; i < input.length; i += 4){
					MoveSet[i] = Integer.parseInt(input[i]);
					MoveSet[i+1] = Integer.parseInt(input[i+1]);
					MoveSet[i+2] = Integer.parseInt(input[i+2]);
					MoveSet[i+3] = Integer.parseInt(input[i+3]);

					//check for valid movement
					if (board.validMove(MoveSet[i], MoveSet[i+1], MoveSet[i+2], MoveSet[i+3]) == true){
						// change position values of piece
						board.changeChessPiece(MoveSet[i], MoveSet[i+1], MoveSet[i+2], MoveSet[i+3]);
						out.print("valid ");
					}
					else{
						out.print("invalid ");
					}
				}
				out.print("\n");

				// check for 'check'
				boolean check = false;
				char Check = board.check();
				if (Check == '-'){
					check = false;
				}
				else {
					check = true;
				}

				boolean checkmate = false;

				/*
				// check for checkmate
				boolean checkmate = false;
				char Checkmt;
				Checkmt = checkmate();
				if (Checkmt == '-'){
					checkmate = false;
				}
				else {
					checkmate = true;
				}
				checkmate = false;
				*/

				/*
				if (check == true && checkmate == true){
					// print if white or black is in checkmate
					if (Checkmt == 'w'){
						out.print("White checkmated \n");
					}
					else if (Checkmt == 'b'){
						out.print("Black checkmated \n");
					}
				}
				*/
				
				// replace "if" with "else if"
				if (check == true && checkmate == false){
					// print if white or black is in check
					if (Check == 'w'){
						out.print("Black has White in check \n");
					}
					else if (Check == 'b'){
						out.print("White has Black in check \n");
					}
				}
				else {
					out.print("All kings safe \n");					
				}

			}
			lineNum++;
		}
		in.close();
  	}

  	// main operations method
  	public static void main(String[] args) throws IOException, FileNotFoundException, NullPointerException{
		// in = new BufferedReader(new FileReader("input.txt"));
		in = new Scanner(new File("input.txt"));
		out = new PrintWriter(new FileWriter("analysis.txt"));

		Operate();

		//in.close();
		out.close();
	}
}

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

// Subsquent classes for the pieces

class King extends ChessPiece{
	public King(){
		super();
	}

	public King(int x, int y, boolean color){
		super(x, y, color);
	}

	public boolean isAttacking(int x, int y){
		int attackx[] = {-1, -1, 0, 1, 0, 1, 1, -1}; // possible attack row positions
        int attacky[] = {0, -1, -1, -1, 1, 1, 0, 1}; // possible attack col positions

        for(int i = 0; i < 8; i++) {
          	if(this.getx() + attackx[i] == x && this.gety() + attacky[i] == y) {
            	return true;
          	}
        }
        return false;
    }
}

class Queen extends ChessPiece{
	public Queen(){
		super();
	}

	public Queen(int x, int y, boolean color){
		super(x, y, color);
	}

	public boolean isAttacking(int x, int y){
		if (this.getx() == x || this.gety() == y) // if self has same row or column as chesspiece, self is attacking
            return true;
        else if (Math.abs(this.getx() - x) == Math.abs(this.gety() - y)) // if self is on same diagonal as chesspiece, this is attack. we use absolute values to determine diagonal
            return true;
        else
            return false;
	}
}

class Bishop extends ChessPiece{
	public Bishop(){
		super();
	}
	
	public Bishop(int x, int y, boolean color){
		super(x, y, color);
	}

	public boolean isAttacking(int x, int y){
		if (Math.abs(this.getx() - x) == Math.abs(this.gety() - y)) // if self is on same diagonal as chesspiece, this is attack. we use absolute values to determine diagonal
          return true;
      else
          return false; // self is not attacking chesspiece at position l
	}
}

class Rook extends ChessPiece{
	public Rook(){
		super();
	}

	public Rook(int x, int y, boolean color){
		super(x, y, color);
	}

	public boolean isAttacking(int x, int y, boolean color){
		if (this.getx() == x || this.gety() == y) // if self has same row or column as chesspiece, self is attacking
          return true;
      else
          return false; // self is not attacking chesspiece
	}
}

class Knight extends ChessPiece{
	public Knight(){
		super();
	}

	public Knight(int x, int y, boolean color){
		super(x, y, color);
	}

	public boolean isAttacking(int x, int y, boolean color){
		int attackx[] = {-1, 1, -1, 1, -2, -2, 2, 2}; // possible attack row positions
   		int attacky[] = {-2, -2, 2, 2, -1, 1, -1, 1}; // possible attack col positions

       	for(int i = 0; i < 8; i++) {
       		if(this.getx() + attackx[i] == x && this.gety() + attacky[i] == y) {
           		return true;
        	}
        }
        return false;
	}
}

class Pawn extends ChessPiece{
	public Pawn(){
		super();
	}

	public Pawn(int x, int y, boolean color){
		super(x, y, color);
	}

	public boolean isAttacking(int x, int y, boolean color){
		int[] attackx = {0, 0};
    	int[] attacky = {0, 0};

     	if(this.getColor() == true) {
        	// if it is a white pawn
        	// then it advances from bottom to top (unidirectional) in a chessboard
        	// attacks only one step diagonals
        	attackx[0] = 1;
        	attackx[1] = 1;
        	attacky[0] = -1;
        	attacky[1] = 1;
      	}
      	else if(this.getColor() == false) {
        	// if it is a black pawn
        	// then it advances from top to bottom (unidirectional) in a chessboard
        	// attacks only one step diagonals
        	attackx[0] = -1;
        	attackx[1] = -1;
        	attacky[0] = -1;
        	attacky[1] = 1;
      	}
      	for(int i = 0; i < 2; i++) {
        	if(this.getx() + attackx[i] == x && this.gety() + attacky[i] == y) {
        		return true;
        	}
      	}	
      	return false;
	}
}

// handle exceptions
class Handler{
	public static void exitError(String message){
		System.err.println(message);
		System.exit(1);
	}

	public static void printList(Node head){
		Node piece = head.getNext();
		while (piece != null){
			System.out.println("X: "+piece.getx()+",Y: "+piece.gety()+",Color: "+piece.getColor());
			piece = piece.getNext();
		}
	}
}