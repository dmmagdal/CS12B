// FileReverse.java

import java.io.*;
import java.util.Scanner;

class FileReverse{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));
		String line = null;
		String[] token = null;
		int n;

		if (args.length < 2){
			System.out.println("Usage: FileReverse <input file> <output file>");
			System.exit(1);
		}

		while (in.hasNextLine()){
			line = in.nextLine().trim()+" ";
			token = line.split("\\s+");
			n = token.length;
			
			for (int i = 0; i < n; i++){
				out.println(StringReverse(token[i]));
			}

		}	

		in.close();
		out.close();

	}

	public static String StringReverse(String s){
		char c = s.charAt(s.length()-1);
		if (s.length() == 1){
			return Character.toString(c);
		}
		return c + StringReverse(s.substring(0, s.length()-1));
	}
}
