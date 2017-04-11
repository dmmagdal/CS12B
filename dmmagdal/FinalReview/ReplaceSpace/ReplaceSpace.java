// ReplaceSpace
// Replace all space characters in a string with '%20'

import java.util.*;
import java.io.*;

class ReplaceSpace{
	public static void main(String[] args) throws IOException, FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

		while(in.hasNextLine()){
			String[] input = in.nextLine().split("\\s");
			String[] newString = new String[input.length*2];
			int i = 0;
			while (i < input.length){
				if (i == input.length-1){
					System.out.print(newString[i] = input[i]);
					newString[i] = input[i];
					out.print(newString[i]);
				}
				else{
					System.out.print(newString[i] = input[i]+"%20");
					newString[i] = input[i]+"%20";
					out.print(newString[i]);
				}
				i++;
			}
		}
		in.close();
		out.close();
	}
}