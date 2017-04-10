JAVASRC		= ChessBoard.java Node.java King.java ChessPiece.java
SOURCES		= makefile $(JAVASRC)
MAINCLASS	= ChessBoard
CLASSES		= ChessBoard.class
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
