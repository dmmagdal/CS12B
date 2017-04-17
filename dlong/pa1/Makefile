CFLAGS=-Wall -Wextra -Werror - pedantic
CC=gcc $(FLAGS)

Parfait	:	Parfait.o
	$(CC) -o Parfait Parfait.o

Parfait.o:	Parfait.c
	$(CC) -c Parfait.c

clean	:
	rm -f Parfait Parfait.o
