// AddLists2
// Takes 2 linked list and adds the values of their respective nodes

import java.util.*;
import java.io.*;

class AddLists2{
	public static Scanner in;
	public static PrintWriter out;

	public static Lists add(Lists l1, Lists l2){
		Node N, P;
		N = l1.head;
		P = l2.head;
		Lists sumlist = new Lists();
		if (l1.numItems > l2.numItems){
			while (P != null){
				sumlist.insert(P.val+N.val);
				P = P.next;
				N = N.next;
			}
			while (N != null){
				sumlist.insert(N.val);
				N = N.next;
			}
		}
		else if (l1.numItems < l2.numItems){
			while (N != null){
				sumlist.insert(P.val+N.val);
				P = P.next;
				N = N.next;
			}
			while (P != null){
				sumlist.insert(P.val);
				P = P.next;
			}
		}
		else { // l1.numItems == l2.numItems
			while (P != null && N != null){
				sumlist.insert(P.val+N.val);
				P = P.next;
				N = N.next;
			}
		}
		return sumlist;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException{
		in = new Scanner(new File("input3.txt"));
		out = new PrintWriter(new FileWriter("output3.txt"));
		int lineNum = 0;

		while (in.hasNextLine()){
			String[] input = in.nextLine().split(" ");
			Lists sum = new Lists();
			Lists list1 = new Lists();
			Lists list2 = new Lists();
			if (lineNum%2 == 0){
				for (int i = 0; i < input.length; i++){
					list1.insert(Integer.parseInt(input[i]));
				}
			}
			else {
				for (int j = 0; j < input.length; j++){
					list2.insert(Integer.parseInt(input[j]));
				}
				sum = add(list1, list2);
				sum.printList();
				out.print("\n");
			}
			lineNum++;
		}
		in.close();
		out.close();
	}
}


class Lists{

	public static int numItems;
	public static Node head;

	public Lists(){
		head = new Node();
		numItems = 0;
	}

	public void insert(int val){
		Node N = new Node(val);
		if (head.val == -1 && head.next == null){
			head = N;
		}
		else {
			Node X = head;
			while (X != null){
				X = X.next;
			}
			X = N;
		}
		numItems++;
	}

	public void printList(){
		Node N = head;
		while (N != null){
			if (N.next == null){
				AddLists2.out.print(N.val+" ");
			}
			else{
				AddLists2.out.print(N.val+"-> ");
			}
			N = N.next;
		}
	}	
}

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