// ChessBoardTest.java
import java.util.Scanner;
import java.io.*;


class ChessBoardTest{
	// global variables
	private static char[][] Board;
	private static int size;
	private static Scanner in;
	private static PrintWriter out;
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// initialize scanner variable
		in = new Scanner(new File("input.txt"));
		out = new PrintWriter(new FileWriter("analysis.txt"));
		
		// initialize other variables for file read/writing and tokenization
		String line = null;
		String[] token = null;
		int i, n, lineNum = 0;
		boolean inVal = false;

		ChessBoard c = null;

		while (in.hasNextLine()){
			// For reading the "even" lines
			// This is the input for board setup
			if (lineNum%2 == 0){
				line = in.nextLine().trim()+" ";
			
				token = line.split("\\s+");

				size = Integer.parseInt(token[0]);
				Board = new char[size][size];
				c = new ChessBoard();

				// set up "blank" board
				for (int a = 0; a < size; a++){
					for (int b = 0; b < size; b++){
						Board[a][b] = '-';
					}
				}

				// set pieces to the Board array and insert new nodes
				for (i = 1; i < token.length; i+=3){
					Board[Integer.parseInt(token[i+1])-1][Integer.parseInt(token[i+2])-1] = token[i].charAt(0);
					// ChessBoard.insert(token[i], token[i+1], token[i+2]);
					c.insert(token[i].charAt(0), Integer.parseInt(token[i+1]), Integer.parseInt(token[i+2]));
				}
				// Check for "invalid" entry
				// Breaks if one exists
				if (c.isEqualNode() == true){
					out.println("INVALID");
					inVal = true;
					break;
				}

				// check to see if there is exaclty ONE king of Each color
				if (c.kings() == false){
					out.println("INVALID");
					inVal = true;
				}
			}
			// For reading the "odd" lines
			// This is for the querry read and isAttacking 
			if (lineNum%2 != 0){
				if (inVal == true){
					break;
				}
				else {
					int querx, query;
				
					line = in.nextLine().trim()+" ";
				
					token = line.split("\\s+");

					// querry X and querry Y variable set
					querx = Integer.parseInt(token[0]);
					query = Integer.parseInt(token[1]);
				
					// print out what's at the querry X, Y and what 2 pieces are attacking eachother
					// out.println(c.findPiece(querx, query)+" "+c.isAttacking()); Needs work on the isAttacking()
					out.println(c.findPiece(querx, query));
				}
			}
			inVal = false;
			lineNum++;

		}

		in.close();
		out.close();

	}
}
