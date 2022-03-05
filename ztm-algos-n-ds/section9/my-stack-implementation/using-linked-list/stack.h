#pragma once
#include "linked_list.h"

class Stack {
  public:
    Stack();

    int Peek();
    void Push(int data);
    int Pop();
    void Print();

    LinkedList* internalList;
};