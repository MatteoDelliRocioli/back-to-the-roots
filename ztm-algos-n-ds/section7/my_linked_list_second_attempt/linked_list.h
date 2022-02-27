#pragma once
#include "node.h"

class LinkedList {
  public:
    Node* head;

    LinkedList();
    LinkedList(int data);
    ~LinkedList();
    void PushBack(int data);
    void Insert(int data, int index);
    void Delete(int index);
    void PrintElements();
};