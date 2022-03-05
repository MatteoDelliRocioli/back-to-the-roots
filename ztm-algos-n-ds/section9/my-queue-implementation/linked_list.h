#pragma once
#include "node.h"

class LinkedList {
  public:
    LinkedList();
    void PushBack(int data);
    int Peek();
    int PopBack();
    LinkedList* Reverse();
    void Print();

    Node* head;
    Node* tail;
};