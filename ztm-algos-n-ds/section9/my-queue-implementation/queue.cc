#include "queue.h"
#include <iostream>

using namespace std;

Queue::Queue() : internalList(new LinkedList()) {
  cout << "created a new Queue" << endl;
}

int Queue::PeekFront() {
  return internalList->PeekFront();
}

int Queue::Peek() {
  return internalList->Peek();
}

void Queue::Enqueue(int data) {
  internalList->PushFront(data);
}

int Queue::Dequeue() {
  return internalList->PopBack();
}