#pragma once
#include "node.h"

class LinkedList {
  public:
    Node* head;

    LinkedList();
    ~LinkedList();
    void Insert(int data);
};