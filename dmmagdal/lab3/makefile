# Makefile FileReverse.c
FileReverse: FileReverse.o
	gcc -o FileReverse FileReverse.o

FileReverse.o: FileReverse.c
	gcc -c -std=c99 FileReverse.c

clean:
	rm -f FileReverse FileReverse.o
