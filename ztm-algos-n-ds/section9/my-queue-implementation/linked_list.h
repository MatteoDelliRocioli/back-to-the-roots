#pragma once
#include "node.h"

class LinkedList {
  public:
    LinkedList();
    void PushFront(int data);
    void PushBack(int data);
    int PeekFront();
    int Peek();
    int PopFront();
    int PopBack();
    LinkedList* Reverse();
    void Print();

    Node* head;
    Node* tail;
};