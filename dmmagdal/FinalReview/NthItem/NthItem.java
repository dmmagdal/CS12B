// NthItem
// returns the nth to last item in a linkedlist

import java.util.*;
import java.io.*;

class NthItem{
	private static Scanner in;
	private static PrintWriter out;
	private static Node head;
	private static int numItems;

	public NthItem(){
		head = new Node();
		numItems = 0;
	}

	public void insert(int val){
		Node N = new Node(val);
		if (N.val == -1 && head.next == null){
			head = N;
		}
		else {
			N.next = head;
			head = N;
		}
		numItems++;
	}

	public int find(int target){
		Node N = new Node();
		if (target > numItems){
			out.print("Can not return the nth to last item when it is larger than the size of the list.");
		}
		else{
			N = head;
			for (int i = 0; i < numItems-target; i++){
				N = N.next;
			}
		}
		return N.val;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException{
		in = new Scanner(new File("input2.txt"));
		out = new PrintWriter(new FileWriter("output2.txt"));
		int lineNum = 0;
		// String line;
		NthItem list = null;

		while (in.hasNextLine()){
			String[] input = in.nextLine().split(" ");
			if (lineNum%2 == 0){
				// read the input for the list
				list = new NthItem();
				for (int i = 0; i < input.length; i++){
					list.insert(Integer.parseInt(input[i]));
				}
			}
			else{
				// read the nth number 
				int x = Integer.parseInt(input[0]);
				out.println(list.find(x));
			}
			lineNum++;
		}
		in.close();
		out.close();
	}
}

// Node class for the LinkedList
class Node{
	public int val;
	public Node next;

	public Node(){
		this.val = -1;
		this.next = null;
	}

	public Node(int val){
		this.val = val;
	}
}