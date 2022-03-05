#pragma once
#include "linked_list.h"

class Queue {
  public:
    Queue();

    int PeekFront();
    int Peek();
    void Enqueue(int data);
    int Dequeue();

  private:
    LinkedList* internalList;
};