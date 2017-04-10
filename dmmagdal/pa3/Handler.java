class Handler{
	public static void exitError(String message){
		System.err.println(message);
		System.exit(1);
	}

	public static void printList(Node head){
		Node piece = head.getNext();
		while (piece != null){
			System.out.println("X: "+piece.getx()+",Y: "+piece.gety()+",Color: "+piece.getColor());
			piece = piece.getNext();
		}
	}
}