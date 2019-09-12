// Subsquent classes for the pieces

class King extends ChessPiece{
	public King(){
		super();
	}

	public King(int x, int y, boolean color){
		super(x, y, color);
	}

	public boolean isAttacking(){
		int attackx[] = {-1, -1, 0, 1, 0, 1, 1, -1}; // possible attack row positions
        int attacky[] = {0, -1, -1, -1, 1, 1, 0, 1}; // possible attack col positions

        for(int i = 0; i < 8; i++) {
          	if(this.getx() + attackx[i] == x && this.gety() + attacky[i] == y) {
            	return true;
          	}
        }
        return false;
    }
}