// RemoveDuplicate
// Removes duplicates in linkedlist

import java.util.*;
import java.io.*;

class RemoveDuplicate{
	private static Node head;
	private static Scanner in;
	private static PrintWriter out;

	public RemoveDuplicate(){
		head = new Node();
	}

	// insert new node
	public void insert(int val){
		Node N = new Node(val);
		if (head.val == -1){
			head = N;
		}
		else{
			N.next = head;
			head = N;
		}
	}

	public void deleteDuplicates(){
		Node N = head;
		Node Prev;
		while (N != null){
			Node Next = N.next;
			while (Next != null){
				if (N.val == Next.val){
					Prev = head;
					while(Prev.next.val != Next.val){
						Prev = Prev.next;
					}
					Prev.next = Next.next;
				}
				Next = Next.next;
			}
			N = N.next;
		}
	}

	public void printlist(){
		Node N = head;
		while (N != null){
			if (N.next == null){
				out.print(N.val+" ");
			}
			else{
				out.print(N.val+"-> ");
			}
			N = N.next;
		}
	}

	public static void main(String[] args) throws IOException, FileNotFoundException{
		in = new Scanner(new File("input1.txt"));
		out = new PrintWriter(new FileWriter("output1.txt"));

		while(in.hasNextLine()){
			String[] input = in.nextLine().split("\\W+");
			RemoveDuplicate list = new RemoveDuplicate();
			int k = 1;
			while (k < input.length){
				list.insert(Integer.parseInt(input[k]));
				k++;
			}
			list.deleteDuplicates();
			list.printlist();
			out.print("\n");
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