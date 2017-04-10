// ChessBoard.java

// ChessBoardTest.java
import java.util.Scanner;
import java.io.*;

class ChessBoardTest{
  // global variable
  public static int size;
  public static char w;
  public static char b;
  
  public static void main(String[] args) throws FileNotFoundException, IOException{
    // initialize scanner variable
    Scanner in = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new FileWriter("analysis.txt"));
    
    // initialize other variables for file read/writing and tokenization
    String line = null;
    int i, lineNum = 0;
    boolean inVal;
                            

    while (in.hasNextLine()){
      ChessBoard Game = new ChessBoard();
      line = in.nextLine().trim()+" ";
      String[] token = line.split("\\s+");
      inVal = false;

      // For reading the "even" lines
      // This is the input for board setup
      if (lineNum%2 == 0){             
        int size = Integer.valueOf(token[0]); // n is the size of the board

        // set pieces to the Board array and insert new nodes
        for (i = 1; i < token.length; i += 3){
          int c = Integer.valueOf(token[i+1]);
          int d = Integer.valueOf(token[i+2]);

          // Check for "invalid" entry
          // Breaks if a piece exists already on the square
          if (Game.isEqualNode(c, d) == true){
            out.println("INVALID");
            inVal = true;
            break;
          }

          // create new piece object, add it to a new node, add node to linked list
          switch (token[i].charAt(0)){
            case 'k':
              Game.insert(new King(w, c, d), w, c, d);
              break;
            case 'q':
              Game.insert(new Queen(w, c, d), w, c, d);
              break;
            case 'r':
              Game.insert(new Rook(w, c, d), w, c, d);
              break;
            case 'b':
              Game.insert(new Bishop(w, c, d), w, c, d);
              break;
            case 'n':
              Game.insert(new Knight(w, c, d), w, c, d);
              break;
            case 'K':
              Game.insert(new King(b, c, d), b, c, d);
              break;            
            case 'Q':
              Game.insert(new Queen(b, c, d), b, c, d);
              break;
            case 'R':
              Game.insert(new Rook(b, c, d), b, c, d);
              break;
            case 'B':
              Game.insert(new Bishop(b, c, d), b, c, d);
              break;
            case 'N':
              Game.insert(new Knight(b, c, d), b, c, d);
              break;
          }
        }

        

        // check to see if there is exaclty ONE king of Each color
        if (Game.King() == false){
          out.println("INVALID");
          inVal = true;
          break;
        }

      }

      // For reading the "odd" lines
      // This is for the querry read and isAttacking 
      if (lineNum%2 != 0){
        if (inVal == true){
          break;
        }
        else {
          /*int num = 0;
          while (Game.size > num && ){
            num++;
          } */

          int querx, query;
          // querry X and querry Y variable set
          querx = Integer.valueOf(token[0]);
          query = Integer.valueOf(token[1]);
          // print out what's at the querry X, Y and what 2 pieces are attacking eachother
          out.println(Game.findPiece(querx,query));
        }
      }
    lineNum++;

    }

    in.close();
    out.close();

  }
}


// ChessBoard.java
// creates LinkedLst ADT
class ChessBoard{
 private class Node{
    char c;
    int x, y;
    Node next;
    ChessPiece piece = new ChessPiece();

    public Node(ChessPiece piece, char c, int x, int y){
      c = this.c;
      x = this.x;
      y = this.y;

      piece = this.piece;
      next = null; 
    }
  }
	private Node head;
  private int size;

        public ChessBoard(){
          size = 0;
          head = null;
        }

//finds chess piece at squre x, y
	public char findPiece(int xcoords, int ycoords){
		Node N = head;
    // Node E = new Node();
		while (N.next != null){
			if (xcoords == N.piece.col && ycoords == N.piece.row){
				break;
			}
			N = N.next;
      if (N.next == null && xcoords != N.piece.col && ycoords != N.piece.row){
        return '-';
      } 
		}
    switch(N.piece.getClass().getName()){
      case "King":
        if (N.piece.color == 'w'){
          return 'k';
        }
        else{
          return 'K';
        }
        break;
      case "Queen":
        if (N.piece.color == 'w'){
          return 'q';
        }
        else{
          return 'Q';
        }
        break;
      case "Rook":
        if (N.piece.color == 'w'){
          return 'r';
        }
        else{
          return 'R';
        }
        break;
      case "Bishop":
        if (N.piece.color == 'w'){
          return 'b';
        }
        else{
          return 'B';
        }
        break;
      case "Knight":
        if (N.piece.color == 'w'){
          return 'n';
        }
        else{
          return 'N';
        }
        break;
	  }
  }

//checks for 2 pieces on same square
  public boolean isEqualNode(int xcoords, int ycoords){     
    boolean ret = false;
    if (findPiece(xcoords, ycoords) != '-'){
      ret = true;
    }
    else{
      ret = false;
    }
    return ret;
  }                         

//checks for King condition
  public boolean King(){
    Node N = head;
    int numWk = 0;
    int numBK = 0;
    while (N.next != null){     
      if (N.piece.getClass().getName() == "King"){
        if (N.piece.color == 'w'){
          // count number of white kings
          numWk += 1;
        } 
        else{
          // count number of black kings 
          numBK += 1 ;
        }
      }           
      N = N.next;
    }
    if (numWk == 1 && numBK == 1){
      return true;
    } 
    else {
      return false;
    }
  }   

//inserts node
	public void insert(ChessPiece piece, char c, int xcoords, int ycoords){ 
		Node N = new Node(piece, c, xcoords, ycoords);
		N.next = head;
	  head = N;
    size++;
	}
}



// ChessPiece.java
// Create ChessPiece Superclass
class ChessPiece{
  int col;
  int row;
  char color;

  public void ChessPiece(char c, int x, int y){
    x = col;
    y = row;
    c = color;
  }

  public boolean isAttacking(){
    return false;
  }
}



class King extends ChessPiece {
  public King(char c, int x, int y) {
    super(c, x, y);
  }

  public Boolean isAttacking(ChessPiece piece) { ///
    if ((Math.abs(this.col - piece.col) <= 1) && (Math.abs(this.row - piece.row) <= 1)) {
      return true;
    }
    return false;
  }
}



class Queen extends ChessPiece {
  public Queen(char c, int x, int y) {
    super(c, x, y);
  }

  public Boolean isAttacking(ChessPiece piece) { ///
    if ((this.col == piece.col) || (this.row == piece.row) || (Math.abs(this.col - piece.col) == Math.abs(this.row - piece.row))) {
      return true;
    }
    return false;
  }
}



class Rook extends ChessPiece {
  public Rook(char c, int x, int y) {
    super(c, x, y);
  }

  public Boolean isAttacking(ChessPiece piece) { ///
    if ((this.col == piece.col) || (this.row == piece.row)) {
      return true;
    }
    return false;
  }
}



class Bishop extends ChessPiece {
  public Bishop(char c, int x, int y) {
    super(c, x, y);
  }

  public Boolean isAttacking(ChessPiece piece) { ///
    if (Math.abs(this.col - piece.col) == Math.abs(this.row - piece.row)) {
      return true;
    }
    return false;
  }
}



class Knight extends ChessPiece {
  public Knight(char c, int x, int y) {
    super(c, x, y);
  }

  public Boolean isAttacking(ChessPiece piece) { ///
    if (Math.abs((this.col - piece.col)*(this.row - piece.row)) == 2) {
      return true;
    }
    return false;
  }
}