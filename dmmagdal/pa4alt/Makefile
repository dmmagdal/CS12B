JAVASRC		= Priority.java
SOURCES		= makefile $(JAVASRC)
MAINCLASS	= Priority
CLASSES		= Priority.class Node.class
JARFILE		= Priority.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)
