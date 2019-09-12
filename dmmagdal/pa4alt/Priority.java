// Priority

import java.util.Scanner;
import java.io.*;

class Priority{
	private static Node head;
	private static Node tail;
	private int numitems;

	private static Scanner in;
	private static PrintWriter out;

	// constructor
	public Priority(){
		head = new Node();
		tail = head;
		numitems = 0;
	}

	// find a target value in the queue
	public Node find(int target){
		Node N = head;
    	while(N != null) {
      		if(N.priority == target) {
        		return N;
      		}
     		N = N.next;
    	}
    	return null;
	}

	// insert new node
	public void insert(int val, int priority){
		Node N = new Node(val, priority);
		if (head.priority == -1 && head.val == -1){
			head = N;
		}
		tail.next = N;
		tail = N;
		numitems++;
	}

	// delete highest priority
	public void deleteMax(){
		Node N = head;
		int hpriority = head.priority; //store the highest priority
		// if queue is empty
		if (head == null){
			out.print("Error: Can not delete from empty Queue");
		}
		// otherwise execute
		else{
			// scan linked list
			while (N != null){
				// set hpriority to highest priority value found in the linked list
				if (hpriority < N.priority){
					hpriority = N.priority;
				}
				N = N.next;
			}
			// use find() to find the node with the highest priority value and set that to N
			// initialize Prev node and increment it until it is the node before N
			N = find(hpriority);
			out.print(N.val+" "); //<------------------------------------------------------UNcomment when done.
			Node Prev = head;
			if (N.priority == head.priority && N.val == head.val){
				// if the highest priority is in the head
				if (head.next == null){
					// if the head is the only item in the linked list
					head = new Node();
				}
				else{
					head = head.next;
				}
			}
			else{
				while (Prev.next.priority != N.priority && Prev.next.val != N.val){
					Prev = Prev.next;
				}
				if (N.next == null){
					// if the highest priority is in the tail
					Prev.next = null;
					tail = Prev;
				}
				else{
					Prev.next = N.next;
				}
			}
			numitems--;
		}
	}

	// print queue
	public void printPriority(){
		Node N = head;
		while (N != null){
			if (N.next == null){
				out.print(N.priority+", "+N.val+" ");
			}
			else{
				out.print(N.priority+", "+N.val+"-> ");
			}
			N = N.next;
		}
	}
	
	//executes all operations
  	public static void main(String[] args) throws IOException, NullPointerException{
  		in = new Scanner(new File("input.txt"));
		out = new PrintWriter(new FileWriter("output.txt"));

		Priority q = null;
		String line;
		
		// for BufferedReader, use in.readLine()
		// for Scanner, use in.nextLine()
		while (in.hasNextLine()){
			String[] input = in.nextLine().split("\\W+");
			q = new Priority();
			int k = 1;
			while (k < input.length){
				if (input[k].equals("d")){
					q.deleteMax();
					// q.printPriority();
					// out.println("\n");
					k++;
				}
				else{
					q.insert(Integer.parseInt(input[k]), Integer.parseInt(input[k+1]));
					// q.printPriority();
					// out.println("\n");
					k += 2;
				}
			}
		}
		in.close();
		out.close();
  	}
}

// Node class for the LinkedList
class Node{
	public int priority;
	public int val;
	public Node next;

	public Node(){
		this.priority = -1;
		this.val = -1;
		this.next = null;
	}

	public Node(int val, int priority){
		this.priority = priority;
		this.val = val;
	}
}