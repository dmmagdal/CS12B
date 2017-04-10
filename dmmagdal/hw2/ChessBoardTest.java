// ChessBoardTest.java
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.lang.*;


class ChessBoardTest{
	// global variables
	//private char[][] Board;
	//private int size;
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// initialize scanner variable
		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));
		
		// initialize other variables for file read/writing and tokenization
		String line = null;
		// String[] token = null;
		int i, lineNum = 0;
		boolean inVal = false;
                char[][] Board;
		ChessBoard Game = new ChessBoard();
                            

		while (in.hasNextLine()){
			// For reading the "even" lines
			// This is the input for board setup
			inVal = false;
			if (lineNum%2 == 0){
                             
				line = in.nextLine().trim()+" ";
			
				String[] token = line.split("\\s+");
                                
			        int n = Integer.valueOf(token[0]); // n is the size of the board
                             
				Board = new char[n+1][n+1];

				// set up "blank" board
				for (int a = 0; a < n; a++){
					for (int b = 0; b < n; b++){
						Board[a][b] = '-';
					}
				}

				// set pieces to the Board array and insert new nodes
				for (i = 1; i < token.length; i+=3){
                                        int c = Integer.valueOf(token[i+1]);
                                        int d = Integer.valueOf(token[i+2]);
					Board[c][d] = token[i].charAt(0);
					// Check for "invalid" entry
					// Breaks if one exists
					if (Game.isEqualNode (c, d) == true){
						out.println("INVALID");
						inVal = true;
						break;
					}

					Game.insert(token[i].charAt(0), c, d);
				}

				// check to see if there is exaclty ONE king of Each color
				if (Game.King() == false){
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
				
					line = in.nextLine().trim();
				
					String[] tokens = line.split("\\s+");
                                        //System.out.println(tokens[0]);
					// querry X and querry Y variable set
					querx = Integer.valueOf(tokens[0]);
					query = Integer.valueOf(tokens[1]);
				       // out.println(querx);
                                       // out.println(query);



				       // print out what's at the querry X, Y and what 2 pieces are attacking eachother
					out.println(Game.print(Game.findPiece(querx, query))+" ");
				}
			}
			inVal = false;
		lineNum++;

		}

		in.close();
		out.close();

	}
}
