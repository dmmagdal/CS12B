// IntegerLinkedList

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "IntegerLinkedList.h"

// Private types---

// NodeObj
typedef struct NodeObj{
	int item;
	struct NodeObj* next;
} NodeObj;

// newNode()
Node newNode(int x){
	Node N = malloc(sizeof(NodeObj));
	assert(N != NULL);
	N->item = x;
	N->next = NULL;
	return(N);
}

// freeNode()
void freeNode(Node *pN){
	if (pN != NULL && *pN != NULL){
		free(*pN);
		*pN = NULL;
	}
}

// LinkedListObj
typedef struct LinkedListObj{
	Node top;
	int numItems;	
} LinkedListObj;

// Public functions---

// newLinkedList()
LinkedList newLinkedList(void){
	LinkedList S = malloc(sizeof(LinkedListObj));
	assert(S != NULL);
	S->top = NULL;
	S->numItems = 0;
	return S;
}

// freeLinkedList()
void freeLinkedList(LinkedList* pS){
	if (pS != NULL && *pS != NULL){
		Node N = (*pS)->top;
		Node temp;
		while (N != NULL){
			temp = N->next;
			freeNode(&N);
			N = temp;
		}
		freeNode(&N);
		free(*pS);
		*pS = NULL;
	}
}

// Definitions of ADT operations

// printLinkedList
void printLinkedList(FILE* out, LinkedList S){
	Node N;
	if (S != NULL){
		fprintf(stderr, "LinkedList Error: calling printLinkedList() on NULL LinkedList reference\n");
		exit(EXIT_FAILURE);
	}
	for (N = S->top; N != NULL; N = N->next){
		if (N->next != NULL){
			fprintf(out, "%d -> ", N->item);
		}
		else{
			fprintf(out, "%d", N->item);
		}
	}
	fprintf(out, "\n");
}

// insert()
void insert(FILE* out, int n, LinkedList S){
	Node N = newNode(n);
	Node Curr;
	if (S->top == NULL){
		S->top = N;
	}
	else{
		Curr = S->top;
		while (Curr->next != NULL){
			Curr = Curr->next;
		}
		Curr->next = N;
	}
	fprintf(out, "inserted %d\n", n);
	S->numItems++;
}

// find()
void find(FILE* out, int n, LinkedList S){
	Node N;
	int boolean = 0;
	for (N = S->top; N != NULL; N = N->next){
		if (N->item == n){
			fprintf(out, "%d present\n", n);
			boolean = 1;
		}
	}
	if (boolean != 1){
		fprintf(out, "%d not present\n", n);
	}
}

// delete()
void delete(FILE* out, int n, LinkedList S){
	Node N;
	Node Prev;
	for (N = S->top; N != NULL; N = N->next){
		if (N->item == n){
			//N = N->next;
			if (N == S->top){
				S->top = N->next;
			}
			else{
				Prev.next = N->next;
			}
			freeNode(*N);
			fprintf(out, "%d deleted\n", n);
			S->numItems--;
		}
		Prev = N;
	}
}