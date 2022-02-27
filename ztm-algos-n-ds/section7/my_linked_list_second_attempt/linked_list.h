#pragma once
#include "node.h"

class LinkedList {
  public:
    Node* head;

    LinkedList();
    LinkedList(int data);
    ~LinkedList();
    void Insert(int data);
    void PrintElements();
};