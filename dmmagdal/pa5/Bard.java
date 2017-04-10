// Bard2

import java.util.*;
import java.io.*;

class Bard{
	private static Node head;
	private static Node tail;
	private int numitems;

	private static Scanner in;
	private static Scanner bd;
	private static PrintWriter out;

	// constructor
	public Bard(){
		head = new Node();
		tail = head;
		numitems = 0;
	}

	// find a target value in the queue
	public Node find(String targetkey){
		Node N = head;
    	while(N != null) {
      		if(N.key == targetkey) {
        		return N;
      		}
     		N = N.next;
    	}
    	return null;
	}

	// find the keys of the val most frequent words
	public Node freqFind(int freq){
		Node N = head;
		while(N != null){
			if (N.val == freq){
				return N;
			}
			N = N.next;
		}
		return null;
	}

	// delete highest priority
	public void deleteMax(){
		Node N = head;
		int hpriority = head.val; //store the highest priority
		// if queue is empty
		if (head == null){
			out.print("Error: Can not delete from empty Queue");
		}
		// otherwise execute
		else{
			// scan linked list
			while (N != null){
				// set hpriority to highest priority value found in the linked list
				if (hpriority < N.val){
					hpriority = N.val;
				}
				N = N.next;
			}
			// use find() to find the node with the highest priority value and set that to N
			// initialize Prev node and increment it until it is the node before N
			N = freqFind(hpriority);
			out.print(N.key+" "); //<------------------------------------------------------UNcomment when done.
			Node Prev = head;
			if (N.key == head.key && N.val == head.val){
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
				while (Prev.next.key != N.key && Prev.next.val != N.val){
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

	// insert new node
	public void insert(String key, int val){
		Node N = new Node(key, val);
		if (head.key == null && head.val == -1){
			head = N;
		}
		tail.next = N;
		tail = N;
		numitems++;
	}

	// find largets keys repeat number of times
	public void findMax(int repeat){
		while (repeat != 0){
			deleteMax();
			repeat--;
		}
	}

	// print queue
	public void printList(){
		Node N = head;
		while (N != null){
			if (N.next == null){
				out.print(N.key+", "+N.val+" ");
			}
			else{
				out.print(N.key+", "+N.val+"-> ");
			}
			N = N.next;
		}
	}
	
	//executes all operations
  	public static void main(String[] args) throws IOException, FileNotFoundException{
		in = new Scanner(new File("input.txt"));
		bd = new Scanner(new File("shakespeare.txt"));
		out = new PrintWriter(new FileWriter("analysis.txt")); 

		Hashtable<String, Integer> bard = new Hashtable<String, Integer>();

		// read and store words from Bard to hash table
		while (bd.hasNextLine()){
			String[] text = bd.nextLine().split("[^'a-zA-Z0-9_-]+");
			// convert all string to lower case
			for (int i = 0; i < text.length; i++){
				text[i] = text[i].toLowerCase();
			}
			int j = 0;
			// Scan through the array
			while (j < text.length) {
				if (bard.containsKey(text[j])){
					//if key already exists, increment value by 1
					int k = bard.get(text[j]); // set k to the value set in key text[j]
					bard.remove(text[j]); // remove key text[j] from hash table
					bard.put(text[j], new Integer(k+1)); // make new entry for key text[j] and save value k+1 
				}
				else{
					//Scan and input words into hash table
					bard.put(text[j], new Integer(1)); // this is for new unique keys only
				}
				j++;
			}
		}

		/*
		// prints out the hastable
		Enumeration<String> words;
		words = bard.keys();
		String freq;
		while (words.hasMoreElements()){
			freq = words.nextElement();
			System.out.println("Key: "+freq+" & value "+bard.get(freq));
		}
		*/
		
		// read querry from input.txt 
		while (in.hasNextLine()){
			String[] input = in.nextLine().split("\\W+");
			int k = input.length;
			if (k < 2){
				// if the querry is a word
				out.println(bard.get(input[0])); // assuming that all word queries are lower case
			}
			else{
				// otherwise the querry is assumed to be numbers
				int l = Integer.parseInt(input[0]);
				int m = Integer.parseInt(input[1]);
				Bard list = new Bard();
				Enumeration<String> words;
				words = bard.keys();
				String freq;
				while (words.hasMoreElements()){
					freq = words.nextElement();
					if (freq.length() == l){
						list.insert(freq, bard.get(freq));
					}
				}
				list.findMax(m);
				out.print("\n");
			}
		}
		in.close();
		bd.close();
		out.close();
	}
}

// Node class for the LinkedList
class Node{
	public String key;
	public int val;
	public Node next;

	public Node(){
		this.key = null;
		this.val = -1;
		this.next = null;
	}

	public Node(String key, int val){
		this.key = key;
		this.val = val;
	}
}