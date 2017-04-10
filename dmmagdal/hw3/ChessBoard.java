// Chessmoves.java

import java.util.Scanner;
import java.io.*;

// LinkedList ADT
class ChessBoardADT{
	private static int boardize;
	private static Node head;
	private boolean val;
	private static BufferedReader in;
	private static PrintWriter out;

	// constructor
	public ChessBoardADT(){
		head = new Node();
	}

	/*
	// check to see if pieces are attacking eachother
	public Node isOneAttackingOther() {
    	// get the first valid chesspiece (remember not the head)
    	Node piece = head.getNext();
    	// loop through each of the remaining chesspieces and check for attack
    	while(piece != null) {
    		Node other = head.getNext();
    		while(other != null) {
        		if(isDifferent(piece, other) && piece.getChessPiece().isAttacking(other.getx(), other.gety())) {
          		// true for this 'other' piece
        			return other;
        		}
        		other = other.getNext();
    		}
    		piece = piece.getNext();
  		}
  		return null;
  	}
  	*/



	// return a node with coords x and y
	public Node findChessPiece(int x, int y){
		Node piece = head.getNext();
    	while(piece != null) {
      		if(piece.getx() == x && piece.gety() == y) {
        		return piece;
      		}
     		piece = piece.getNext();
    	}
    	return null;
	}

	// find a node, then change its x and y
	public void changeChessPiece(int x1, int y1, int x2, int y2){
		Node foundPiece = findChessPiece(x1, y1);
    	if (foundPiece != null) {
    		// if a piece is returned, change the x and y of the piece
      		foundPiece.piece.setx(x2);
      		foundPiece.piece.sety(y2);
    	}
   		
	}

	// check if movement is validMove
	public boolean validMove(int x1, int y1, int x2, int y2){
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

  	//executes all operations
  	public static void Operate() throws IOException{
  		int lineNum = 0;
		ChessBoardADT board = null;
		String line;
		int[] MoveSet;
		
		while ((line = in.readLine()) != null){
			//line = in.nextLine();
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
  	public static void main(String[] args) throws IOException, FileNotFoundException{
		in = new BufferedReader(new FileReader("input.txt"));
		out = new PrintWriter(new FileWriter("analysis.txt"));

		Operate();

		//in.close();
		out.close();
	}
}