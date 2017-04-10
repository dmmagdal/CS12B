# makefile pa2 in MACROS

JAVASRC		= ChessBoard.java ChessBoardTest.java ChessPiece.java Queen.java King.java Rook.java Bishop.java Knight.java Pawn.java PieceNotFoundException.java
SOURCES		= README makefile $(JAVASRC)
MAINCLASS	= ChessBoardTest
CLASSES		= ChessBoard.class ChessBoardTest.class ChessPiece.class Queen.class King.class Rook.class Bishop.class Knight.class Pawn.class PieceNotFoundException.class 
JARFILE		= ChessBoardTest.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)
