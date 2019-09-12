// IntegerLinkedList

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

// printLinkedList()
void printLinkedList(FILE* out, LinkedList S);

// insert()
void insert(int number, LinkedList S);

// find()
void find(int number, LinkedList S);

// delete()
void delete(int n, LinkedList S);

#endif

