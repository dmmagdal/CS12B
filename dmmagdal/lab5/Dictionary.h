// Dictionary.h

#ifndef _INTEGER_LINKEDLIST_H_INCLUDE_
#define _INTEGER_LINKEDLIST_H_INCLUDE_

#include <stdio.h>

// LinkedList
typedef struct LinkedListObj* LinkedList;

// Node
typedef struct  NodeObj* Node;

// constructor for node
Node newNode(int x);

// newLinkedList()
LinkedList newLinkedList(void);

// freeLinkedList()
void freeLinkedList(LinkedList* pS);

// 
void addNode(Node N, LinkedList S);

// printLinkedList()
void printLinkedList(FILE* out, LinkedList S);

// insert()
void insert(FILE* out, int n, LinkedList S);

// find()
void find(FILE* out, int n, LinkedList S);

// delete()
void delet(FILE* out, int n, LinkedList S);


#endif