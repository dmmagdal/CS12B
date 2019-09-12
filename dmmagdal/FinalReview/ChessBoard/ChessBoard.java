// ChessBoard.java
// Store chessboard to linked list. Tells if chessboard is valid or not.
import java.util.*;
import java.io.*;

class ChessBoard{
	private static int size;
	private static Scanner in;
	private static PrintWriter out;
	private Node head;

	public ChessBoard(){
		head = new Node();
	}

	public void insert(char c, int x, int y){
		Node N = new Node()
	}

	public boolean isValid(){

	}

	public int numBKings(){

	}

	public int numWKings(){

	}

	public ChessPiece find(int x, int y){

	}

	public static void main(String[] args){
		in = new Scanner(new File("input4.txt"));
		out = new PrintWriter(new FileWriter("output4.txt"));

	} 
}

class Node{
	public ChessPiece piece;
	public Node next;

	public Node(){
		this.piece = null;
		this.next = null;
	}

	public Node(char c, int x, int y){
		
		this.next = null;
	}
}

class ChessPiece{
	public ChessPiece(){

	}
}

class King extends ChessPiece{
	public King(){
		super();
	}

	public King(){

	}
}

class Queen extends ChessPiece{
	public Queen(){
		super();
	}

	public Queen(){

	}
}

class Knight extends ChessPiece{
	public Knight(){
		super();
	}

	public Knight(){

	}
}

class Bishop extends ChessPiece{
	public Bishop(){
		super();
	}

	public Bishop(){

	}
}

class Rook extends ChessPiece{

}