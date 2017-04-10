// ChessBoardInterface.java

public interface ChessBoardInterface{
	public String findPiece(int xcoords, int ycoords);

	public boolean isEqualNode(int xcoords, int ycoords);

	public boolean King();

	public void insert(String p, int x, int y);
}

