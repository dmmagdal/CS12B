// ChessBoard.java
import java.util.Scanner;
import java.IO.*;

class ChessBoard{

	public static int BoardSize;
	public static LinkedListADT Board

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("analysis.txt"));

		

		while (in.hasNextLine()){
			//  variable setup for reading each line
			LinkedListADT Board = new LinkedlistADT();
			String line = in.nextLine();
			String[] tokens = tokenize((line));

			for (int i = 0; i < tokens.length; i++){
				if (i == 0){
					// read board size
					BoardSize = Integer.parseInt(tokens[i]);
				}
				else if ((i+2)%3 == 0){
					//Create and add chesspiece to linked list
					switch (tokens[i]){
						case 'k':
							Board.add(new King((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						case 'q':
							Board.add(new Queen((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						case 'r':
							Board.add(new Rook((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						case 'b':
							Board.add(new Bishop((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						case 'n':
							Board.add(new Knight((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						case 'p':
							Board.add(new Pawn((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						case 'K':
							Board.add(new King((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						case 'Q':
							Board.add(new Queen((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						case 'R':
							Board.add(new Rook((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));							break;
						case 'B':
							Board.add(new Bishop((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						case 'N':
							Board.add(new Knight((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						case 'P':
							Board.add(new Pawn((Character.isUpperCase(tokens[i].charAt(0)) ? "Black" : "White"), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
							break;
						}
				}
			}

			// check if board is valid
			if (Board.isValid(BoardSize)){
				Node query = Board.nodeAt(Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray());

				System.out.print((query != null ? query.piece.toSadString().charAt(0)+" " : "-"));
				out.print((query != null ? query.piece.toSadString().charAt(0)+" " : "-"));
			}

		}

	}

}

class Node{
	Node next;
	ChessPiece piece = new ChessPiece();

	public Node (ChessPiece piece){
		piece = _piece;
		next = null;
	}
}

class LinkedListADT{
	Node head;
	int numItems;

	public LinkedListADT(){
		head = null;
	}

	public char findPiece(int xcoords, int ycoords){
		Node N = head;
		for (int i = 1; i < numItems; i++){
			if (xcoords == N.x && ycoords == N.y){
				return N.p;
				break;
			}
			if (i == numItems-1 && xcoords != N.x && ycoords !- N.y){
				return '-'; 
			}
			N = N.next;
		}
		return N.p
	}

	// add new node to linked list from the head
	public void add(ChessPiece piece){
		Node Latest = new Node(piece);
		Latest.next = head;
		head = Latest;
	}

	public void print(){

	}

	public Node nodeAt(int[] query){
		
	}
}

class ChessPiece{
	
}

class Rook extends ChessPiece{

}

class Knight extends ChessPiece{

}

class Queen extends ChessPiece{

}

class King extends ChessPiece{

}

class Bishop extends ChessPiece{

}

class Pawn extends ChessPiece{

}