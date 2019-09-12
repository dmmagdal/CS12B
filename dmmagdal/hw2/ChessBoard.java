// ChessBoard.java
import java.lang.*;

public class ChessBoard{
        private class Node{
                Node next;
                ChessPiece piece = new ChessPiece();
                char p;
                int x, y;

                public Node(char p, int xcoords, int ycoords){
                        next = null;
                        p = this.p;
                        x = xcoords;
                        y = ycoords;
 
                        switch(p) {
                              case 'k':
                                      piece.CreateKing(xcoords, ycoords);
                                      break;

                              case 'q':
                                      piece.CreateQueen(xcoords, ycoords);
                                      break;

                              case 'r':
                                      piece.CreateRook(xcoords, ycoords);
                                      break;

                              case 'b':
                                      piece.CreateBishop(xcoords, ycoords);
                                      break;

                              case 'n':
                                      piece.CreateKnight(xcoords, ycoords);
                                      break;

                              case 'K':
                                      piece.CreateKing(xcoords, ycoords);
                                      break;
                              
                              case 'Q':
                                      piece.CreateQueen(xcoords, ycoords);
                                      break;

                              case 'R':
                                      piece.CreateRook(xcoords, ycoords);
                                      break;

                              case 'B':
                                      piece.CreateBishop(xcoords, ycoords);
                                      break;

                              case 'N':
                                      piece.CreateKnight(xcoords, ycoords);
                                      break;

                              // break;
                        }
           
                } 

          }
	private Node head;
	private int numItems;

        public ChessBoard(){
             head = null;
             numItems = 0;
        }

//finds chess piece at squre x, y
	public Node findPiece(int xcoords, int ycoords) throws PieceNotFoundException{
		Node N = head;
		for(int i = 1; i < numItems; i++){
			if (xcoords == N.x && ycoords == N.y){
				break;
			}
			N = N.next;
		}
                return N;

	}

//checks for 2 pieces on same square
       public boolean isEqualNode(int xcoords, int ycoords){     
               boolean ret = false;
               Node N = head;
               for (int i = 1; i < numItems; i++){
                   if (xcoords == N.x && ycoords == N.y){
                       ret = true;
                   }else { 
                       ret = false;
                   }
                   N = N.next;
               }
                   return ret;
        }                         

//checks for King condition
      public boolean King (){
             Node N = head;
             int numWk = 0;
             int numBK = 0;
             for (int i = 1; i < numItems; i++){
                 if (N.p == 'k'){
                     numWk +=1;
                 }else if (N.p == 'K'){ 
                     numBK +=1 ;
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
	public void insert(char p, int xcoords, int ycoords){ 
		if (numItems == 0){
			Node N = new Node(p, xcoords, ycoords);
			N.next = head;
			head = N;
		}
		else{
			Node P = new Node(p, xcoords, ycoords);
                        P.next = head;
                        head = P;
		}
		numItems++;
	}
       
        public char print(Node N){
               return N.p;
        }

}
                                                                                                                   
