// ChessPiece.java
// Create ChessPiece Superclass

class ChessPiece{
	int col;
	int row;

	public void ChessPiece(int x, int y){
		x = col;
		y = row;
	}

	public boolean isAttacking(){
		return false;
	}

        public void CreateKing(int x, int y){
                x = col;
                y = row;

                King k = new King();
                k.King(x, y);
        }

        public void CreateQueen(int x, int y){
                x = col;
                y = row;

                Queen q = new Queen();
                q.Queen(x, y);
        }

        public void CreateKnight(int x, int y){
                x = col;
                y = row;

                Knight n = new Knight();
                n.Knight(x, y);
        }

        public void CreateBishop(int x, int y){
                x = col;
                y = row;

                Bishop b = new Bishop();
                b.Bishop(x, y);
        }

        public void CreateRook(int x, int y){
                x = col;
                y = row;

                Rook r = new Rook();
                r.Rook(x, y);
        }

        public void CreatePawn(int x, int y){
                x = col;
                y = row;

                Pawn p = new Pawn();
                p.Pawn(x, y);
        }

}
