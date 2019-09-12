// NQueens.java
// Solves the NQueens problem in response to user input 

import java.io.*;
import java.util.Scanner;

public class NQueens {

	// Global variable Board and board size
	private static int size;
	private static boolean[][] Board;
	private static int x;
	private static int y;

	public static void main(String[] args) throws IOException{
		// Initialize variables
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileWriter("Solutions"));
		//size = Integer.parseInt(args[0]);


		// Check to be sure if there are correct number of command line
		// arguments
		int cmdlnarg = args.length;
		if (cmdlnarg < 3){
			System.out.println("Usage: java -jar NQueens.jar <board size> <x coordinate> <y coordinate> ");
			System.exit(1);
		}

		size = Integer.parseInt(args[0]); // I was getting an ArrayIndexOutOfBoundsException: 0 when I ran this in Eclipse. Moved
		// from previous position up top (commented out) to here
			
		// Initialize board
		Board = new boolean[size][size];
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				Board[i][j] = false;
			}
		}

		//Place queen from command line arguments
		x = Integer.parseInt(args[1]) - 1;
		y = Integer.parseInt(args[2]) - 1;
		Board[x][y] = true;

		// Call recursive algorithm
		boolean SolutionExist = isASolution(size-1);

		// Print out updated board if solution exits
		// and to file solutions
		if (SolutionExist == true){
			for (int i = 0; i < size; i++){
				for (int j = 0; j < size; j++){
					if (Board[i][j] == true){
						System.out.println((i+1)+", "+(j+1));
						out.println((i+1)+", "+(j+1));
					}
				}
			}
		}
		// Response to "No solution" scenario 
		else{
			System.out.println("No Solution");
			out.println("No Solution");
		}

		in.close();
		out.close();

	}

	public static boolean isASolution(int n){
		int i = 0; // increment variable
		
		// Base case
		if (n == 0){
			// Check for any free spaces in column n at base case
			while (i < size){
				if (freeSquare(n, i, x, y) == false){
					i++;
				}
				else{
					Board[n][i] = true;
					return true;
				}
				// if statement for if there are no solutions for the column
				if (i == size-1 && freeSquare(n, i, x, y) == false){
					return false;
				}
			}
		}
		
		// Place queen in free square, if no free 
		// exists, return false
		while (i < size){
			if (freeSquare(n, i, x, y) == false){
				i++;
			}
			else{
				Board[n][i] = true;
				// since there is a true value, i'll call isASolution again
				// to see where this branches off to.
				if (isASolution(n-1) == false){
					Board[n][i] = false;
					i++;
				}
			}
			
			// if statement for if there are no solutions for the column
			if (i == size-1 && freeSquare(n, i, x, y) == false){
				return false;
			}
		}
		return true;
	}
	
	// Tells if the square is free without being attacked
	// Uses n as col (x) and p as row (y)
	// userX is the user entered col and userY is user entered row 
	public static boolean freeSquare(int n, int p, int userX, int userY){
		// If the column is the same as the input column, the 
		// function returns true
		if (n == userX){
			p = userY;
			return true;
		}
		// If queen exists without conflict
		// Board has a true value. If conflict exists, 
		// returns false ("there is no free square").
		
		// Column and row check
		for (int i = 0; i < size; i++){
			
			// Check row for conflict
			if (Board[i][p] == true){
				return false;
			}
			// Check column for conflict
			if (Board[n][i] == true){
				return false;
			}
			
		}
		
		// Diagonal check
		// 
		// Right diagonal
		//
		// If n = size, its up on the side of the board and needs
		// no right diagonal check
		while (n != size-1){
			for (int r = n+1; r < size; r++){
				// Upward
				for (int u = p+1; u < size; u++){
					if (Board[r][u] == true){
						return false;
					}
				}
				// Downward
				for (int d = p-1; d >= 0 ; d--){
					if (Board[r][d] == true){
						return false;
					}
				}
			}
		}
		// Left diagonal
		//
		// If n = 1, its up on the side of the board as well and
		// needs no left diagonal check
		while (n != 0){
			for (int l = n-1; l > 0; l--){
				// Upward
				for (int u = p+1; u < size; u++){
					if (Board[l][u] == true){
						return false;
					}
				}
				// Downward
				for (int d = p-1; d >= 0; d--){
					if (Board[l][d] == true){
						return false;
					}
				}
			}
		}
		return true;
	}

}
