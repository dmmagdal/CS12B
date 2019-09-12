//Test.java

import java.io.*;
import java.util.Scanner;

class Test{
	private static Scanner in;
	private static PrintWriter out;

	public static void main(String[] args) throws IOException, NullPointerException{
		in = new Scanner(new File("input.txt"));
		out = new PrintWriter(new FileWriter("output.txt"));

		//Priority q = null;
		String line;
		
		// for BufferedReader, use in.readLine()
		// for Scanner, use in.nextLine()
		while (in.hasNextLine()){
			// String[] input = in.nextLine().split("[\\W\\s]");
			String[] input = in.nextLine().split("\\W+");
			//q = new Priority();
			int k = 1;
			while (k < input.length){
				if (input[k].equals("d")){
					// if it reads d deletemax()
					out.println("deleted max");
					k++;
				}
				else{
					// if it reads a number, insert() the current index and the following index() 
					out.println("inserted "+input[k]+" "+input[k+1]);
					k += 2;
				}
			}
		}
		in.close();
		out.close();
	}
}