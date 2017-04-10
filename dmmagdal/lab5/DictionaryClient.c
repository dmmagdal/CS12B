// DictionaryClient.c

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <assert.h>
#include <string.h>
#include "Dictionary.h"

#define MAX_STRING_LENGTH 100

int main(int argc, char* argv[]){
	FILE* in;        // input file                  
	FILE* out;       // output file 
	char* line;		 // string holding input line
	LinkedList dict = newLinkedList();	// dictionary variable
	if (dict == NULL){
		fprintf(stderr, "Couldn't allocate LinkedList dict\n");
		exit(EXIT_FAILURE);
	}

	// check command line for correct number of arguments 
	if( argc != 3 ){
	printf("Usage: %s input-file output-file\n", argv[0]);
	exit(EXIT_FAILURE);
	}

	// open input file for reading 
	if( (in=fopen(argv[1], "r"))==NULL ){
	printf("Unable to read from file %s\n", argv[1]);
	exit(EXIT_FAILURE);
	}

	// open output file for writing 
	if( (out=fopen(argv[2], "w"))==NULL ){
	printf("Unable to write to file %s\n", argv[2]);
	exit(EXIT_FAILURE);
	}

	// allocate line on the heap
	line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
	assert(line != NULL);

	// read each line in the input file
	while (fgets(line, MAX_STRING_LENGTH, in) != NULL){
		if (line[0] == 'i'){
			int n;
			char c = line[2];
			sscanf(line, "%c %d", &c, &n);
			insert(out, n, dict);
		}
		else if (line[0] == 'd'){
			int n;
			char c = line[2];
			sscanf(line, "%c %d", &c, &n);
			delet(out, n, dict);
		}
		else if (line[0] == 'f'){
			int n;
			char c = line[2];
			sscanf(line, "%c %d", &c, &n);
			find(out, n, dict);
		}
		else if (line[0] == 'p'){
			printLinkedList(out, dict);
		}

	}

	// free heap memory
	free(line);
	freeLinkedList(&dict);

	// close files
	fclose(in);
	fclose(out);

	return EXIT_SUCCESS;	
}