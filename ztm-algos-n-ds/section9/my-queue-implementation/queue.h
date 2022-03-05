#pragma once
#include "linked_list.h"

class Queue {
  public:
    Queue();

    int Peek();
    void Enqueue();
    int Dequeue();

  private:
    LinkedList* internalList;
};