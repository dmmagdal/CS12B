JAVASRC		= ChessBoard.java Node.java King.java Queen.java Bishop.java Pawn.java Rook.java ChessPiece.java Knight.java Utilities.java
SOURCES		= makefile $(JAVASRC)
MAINCLASS	= ChessBoard
CLASSES		= ChessBoard.class Node.class King.class Queen.class Bishop.class Pawn.class Rook.class ChessPiece.class Knight.class Utilities.java
JARFILE		= ChessBoard.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)