// DictionaryClient.c

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <assert.h>
#include <string.h>
#include "Dictionary.h"

#define MAX_STRING_LENGTH 100

int main(int argc, char* argv[]){                  
	FILE* out;       // output file 
	LinkedList dict = newLinkedList();	// dictionary variable
	if (dict == NULL){
		fprintf(stderr, "Couldn't allocate LinkedList dict\n");
		exit(EXIT_FAILURE);
	}

	// check command line for correct number of arguments 
	if( argc != 2 ){
	printf("Usage: %s output-file\n", argv[0]);
	exit(EXIT_FAILURE);
	}

	// open output file for writing 
	if( (out=fopen(argv[1], "w"))==NULL ){
	printf("Unable to write to file %s\n", argv[1]);
	exit(EXIT_FAILURE);
	}

	insert(out, 42, dict);
	insert(out, 25, dict);
	insert(out, 36, dict);

	find(out, 25, dict);
	find(out, 1, dict);

	printLinkedList(out, dict);

	delet(out, 25, dict);

	// free heap memory
	freeLinkedList(&dict);

	// close files
	fclose(out);

	return EXIT_SUCCESS;	
}