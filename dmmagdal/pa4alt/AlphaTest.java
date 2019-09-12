//AlphaTest.java

import java.io.*;
import java.util.Scanner;

class AlphaTest{
	private static Scanner in;
	private static PrintWriter out;

	public static void main(String[] args) throws IOException, NullPointerException{
		String[] alphabet = new String[10];
		for (int j = 0; j < alphabet.length; j++){
			alphabet[j] = "b";
		}
		alphabet[4] = "a";
		alphabet[8] = "a";
		for (int i = 0; i < alphabet.length; i++){
			if (alphabet[i].equals("a")){
				System.out.println(alphabet[i]+" = a");
				//break;
			}
		}

	}
}