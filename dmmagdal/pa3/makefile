JAVASRC		= ChessBoardADT.java
SOURCES		= makefile $(JAVASRC)
MAINCLASS	= ChessBoardADT
CLASSES		= ChessBoardADT.class Node.class King.class Queen.class Bishop.class Pawn.class Rook.class ChessPiece.class Knight.class Handler.java
JARFILE		= Chessmoves.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)
