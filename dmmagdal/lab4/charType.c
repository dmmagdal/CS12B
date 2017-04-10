
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <assert.h>
#include <string.h>

#define MAX_STRING_LENGTH 100

// function prototype 
void extract_alpha_num(char* s, char* a, char* d, char* p, char* w);

// function main which takes command line arguments 
int main(int argc, char* argv[]){
   FILE* in;        // input file                  
   FILE* out;       // output file                 
   char* line;      // string holding input line              
   char* a; // string holding all alphabetic chars 
   char* d; // numeric chars
   char* p; // puctuation chars
   char* w; // whitespace chars
   int lineNum = 1; 
   int counta, countd, countp, countw;

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

   // allocate strings line and alpha_num on the heap 
   line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   a = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   d = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   p = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   w = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   assert( line != NULL && a != NULL && d != NULL && p != NULL && w != NULL);

   // read each line in input file, extract alpha-numeric characters 
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
      extract_alpha_num(line, a, d, p, w);
      counta = strlen(a);
      countd = strlen(d);
      countp = strlen(p);
      countw = strlen(w);
      fprintf(out, "Line %d contains: \n", lineNum);
      fprintf(out, "%d alphabetic characters: %s\n", counta, a);
      fprintf(out, "%d numeric characters: %s\n", countd, d);
      fprintf(out, "%d puctuation characters: %s\n", countp, p);
      fprintf(out, "%d whitespace characters: %s\n", countw, w);
      lineNum++;
   }

   // free heap memory 
   free(line);
   free(a);
   free(d);
   free(p);
   free(w);

   // close input and output files 
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
}

// function definition 
void extract_alpha_num(char* s, char* a, char* d, char* p, char* w){
   int i=0, j=0, k=0, l=0, m=0;
   while(s[i]!='\0' && i<MAX_STRING_LENGTH){
      if( isalpha( (int)s[i]) ){ 
         a[j++] = s[i];
      }
      if( isdigit( (int)s[i]) ){ 
         d[k++] = s[i];
      }
      if( ispunct( (int)s[i]) ){ 
         p[l++] = s[i];
      }
      if( isspace( (int)s[i]) ){ 
         w[m++] = s[i];
      }
      i++;
   }
   a[j] = '\0';
   d[k] = '\0';
   p[l] = '\0';
   w[m] = '\0';
}