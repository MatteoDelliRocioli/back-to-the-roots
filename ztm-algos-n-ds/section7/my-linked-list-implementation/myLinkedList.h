/*The linked list class will have to:
- be hable to create a new empty linked list
- have the following methods:
	- insert(int value, int position = 0)
	- remove(int position)
	- get(int position)
	- update(int value, int position)
- have the reference to the head and tail nodes at least

value1
 hex1 --> value2
 					 hex2 --> value3
 					 					 hex3 --> etc... valueN
 					 					 								 nullptr
*/
#pragma once

#include "node.h"

class myLinkedList
{
	public:
		node head;
		node tail;

		myLinkedList();
		~myLinkedList();

		//void insert();
		//void remove();
};