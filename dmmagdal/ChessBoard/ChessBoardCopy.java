import java.io.*;
import java.util.*;
// k (king)
// q (queen)
// r (rook)
// b (bishop)
// n (knight)
class ChessBoard {
	public static int boardSize;
	public static LinkedList board;
	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("analysis.txt"));

		while(in.hasNextLine()){
			LinkedList board = new LinkedList();

			String line = in.nextLine();
			String[] tokens = tokenize(line);
			for (int i = 0;i < tokens.length;i++) {
				if (i==0) {
					boardSize = Integer.parseInt(tokens[i]);
				}
				else if((i+2)%3 == 0) {
					//create and add a chessPiece to linked list
					switch(tokens[i].toLowerCase()) {
						case "p": 
							board.add(new Pawn((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"),Integer.parseInt(tokens[i+1]),Integer.parseInt(tokens[i+2])));
							break;
						case "k": 
							board.add(new King((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"),Integer.parseInt(tokens[i+1]),Integer.parseInt(tokens[i+2])));
							break;
						case "q": 
							board.add(new Queen((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"),Integer.parseInt(tokens[i+1]),Integer.parseInt(tokens[i+2])));
							break;
						case "r": 
							board.add(new Rook((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"),Integer.parseInt(tokens[i+1]),Integer.parseInt(tokens[i+2])));
							break;
						case "b": 
							board.add(new Bishop((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"),Integer.parseInt(tokens[i+1]),Integer.parseInt(tokens[i+2])));
							break;
						case "n": 
							board.add(new Knight((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"),Integer.parseInt(tokens[i+1]),Integer.parseInt(tokens[i+2])));
							break;
					}
				}
				
			}
			line = in.nextLine();
			tokens = tokenize(line);

			if (board.isValidBoard(boardSize)) {
				//simple convert string array to int array// no matter what anyone says, this is beautiful
				Node query = board.nodeAt(Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray());

				System.out.print((query!=null ? query.piece.toSadString().charAt(0)+" ":"- "));
				out.print((query!=null ? query.piece.toSadString().charAt(0)+" ":"- "));

				Node i = board.head;
				Boolean k = true;
				while (i != null && k) {
					Node j = board.head;
					while (j != null && k) {
						if ((i != j) && (i.piece.canAttack(j.piece))) {
							System.out.print(i.piece.toSadString()+" "+j.piece.toSadString());
							out.print(i.piece.toSadString()+" "+j.piece.toSadString());
							k = false;
						}
						j = j.next;
					}
					i = i.next;
				}
				if (k) {
					System.out.print("-");
					out.print("-");
				}
				System.out.println("");
				out.println("");

			}
			else {
				System.out.println("Invalid Board");
				out.println("Invalid");
			}
			//System.out.println((board.isValidBoard(boardSize) ? "true":"Invalid"));
      	}
		in.close();
		out.close();
	}
	static String[] tokenize(String string) {
		string = string.trim() + " ";
		return (string.split("\\s+"));
	}
	static int[] getPieceAtLoc() {
		return (new int[] {});
	}
}

class Node {
	ChessPiece piece;
	Node next;
	public Node(ChessPiece _piece) {
		piece = _piece; // points to chess piece
		next = null; //points to next node
	}
}

class LinkedList {
	Node head;

	public LinkedList() {
		head = null;
	}
	public int getLength() { //kill me
		int i = 0;
		Node current = head;
		while (current != null) {
			current = current.next;
			i++;
		}
		return i;
	}
	public void add(ChessPiece piece) {
		Node latest = new Node(piece);
		latest.next = head;
		head = latest;
	}
	public void delete(int[] loc) {
		//
	}
	public void print() {
		Node current = head;
		while (current != null) {
			System.out.println(current.piece);
			current = current.next;
		}
	}
	public Node nodeAt(int[] query) {
		Node current = head;
		while (current != null) {
			//System.out.println(current.piece);
			//System.out.println(query[0] +" "+ query[1]);
			if ((current.piece.getVals()[0] == query[0]) && (current.piece.getVals()[1] == query[1])) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	public ChessPiece[] find(String pieceName) {
		Node current = head;
		ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>();// not cheating i swear
		while (current != null) {
			if (current.piece.getClass().getName() == pieceName) {
				pieces.add(current.piece);
			}
			current = current.next;
		}
		return pieces.toArray((new ChessPiece[pieces.size()]));
	}
	public Boolean isValidBoard(int size) {
		ChessPiece[] kings = this.find("King");
		if (kings.length == 2){ //make sure there are only 2 kings
			if (kings[0].isBlack() != kings[1].isBlack()) { // make sure the kings are different colors
				//return true;
				Node current = head;
				while (current != null) {
					Node nodeFound = nodeAt(current.piece.getVals());
					if (nodeFound != null && nodeFound != current) {
						return false;
					}
					current = current.next;
				}
				return true;
			}
		}
		return false;
	}
}

abstract class ChessPiece {
	String color; // B & W
	int col;
	int row;
	public ChessPiece(String _color, int _col, int _row) {
		color = _color;
		col = _col;
		row = _row;
	}
	public Boolean canAttack(ChessPiece piece) {
		return false;
	}
	public String toString() {
		return (this.color+" "+this.getClass().getName()+" at: "+this.col+","+this.row);
	}
	public String toSadString() {
		return ((this.isBlack()?this.getClass().getName().charAt(0):this.getClass().getName().toLowerCase().charAt(0))+" "+this.col+" "+this.row);
	}
	public int[] getVals() {
		return (new int[]{this.col,this.row});
	}
	public Boolean isBlack() {
		return (this.color == "Black" ? true : false);
	}
	public Boolean isWhite() {
		return (this.color == "White" ? true : false);
	}
}
class Pawn extends ChessPiece {
	public Pawn(String _color, int _col, int _row) {
		super(_color, _col, _row);
	}
	public Boolean canAttack(ChessPiece piece) { /// 
		//White pawns only move upwards (increasing row) and black pawns only move downwards (decreasing row)
		if (this.isBlack()) {
			if ((Math.abs(this.col - piece.col) == 1) && (this.row-1 == piece.row)) {
				return true;
			}
		}
		else {
			if ((Math.abs(this.col - piece.col) == 1) && (this.row+1 == piece.row)) {
				return true;
			}
		}
		return false;
	}
}

class King extends ChessPiece {
	public King(String _color, int _col, int _row) {
		super(_color, _col, _row);
	}
	public Boolean canAttack(ChessPiece piece) { ///
		if ((Math.abs(this.col - piece.col) <= 1) && (Math.abs(this.row - piece.row) <= 1)) {
			
		}
		return false;
	}
}

class Queen extends ChessPiece {
	public Queen(String _color, int _col, int _row) {
		super(_color, _col, _row);
	}
	public Boolean canAttack(ChessPiece piece) { ///
		if ((this.col == piece.col) || (this.row == piece.row) || (Math.abs(this.col - piece.col) == Math.abs(this.row - piece.row))) {
			return true;
		}
		return false;
	}
}

class Rook extends ChessPiece {
	public Rook(String _color, int _col, int _row) {
		super(_color, _col, _row);
	}
	public Boolean canAttack(ChessPiece piece) { ///
		if ((this.col == piece.col) || (this.row == piece.row)) {
			return true;
		}
		return false;
	}
}

class Bishop extends ChessPiece {
	public Bishop(String _color, int _col, int _row) {
		super(_color, _col, _row);
	}
	public Boolean canAttack(ChessPiece piece) { ///
		if (Math.abs(this.col - piece.col) == Math.abs(this.row - piece.row)) {
			return true;
		}
		return false;
	}
}

class Knight extends ChessPiece {
	public Knight(String _color, int _col, int _row) {
		super(_color, _col, _row);
	}
	public String toSadString() {
		return ((this.isBlack()?"N":"n")+" "+this.col+" "+this.row);
	}
	public Boolean canAttack(ChessPiece piece) { ///
		if (Math.abs((this.col - piece.col)*(this.row - piece.row)) == 2) {
			return true;
		}
		return false;
	}
}
