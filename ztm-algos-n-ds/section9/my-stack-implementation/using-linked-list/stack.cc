#include "stack.h"
#include "linked_list.h"
#include <iostream>

using namespace std;

Stack::Stack() : internalList(new LinkedList()) {
  cout << "Created stack instance" << endl;
}

int Stack::Peek() {
  return internalList->Peek();
}

void Stack::Push(int data) {
  internalList->PushBack(data);
}

int Stack::Pop() {
  return internalList->PopBack();
}

void Stack::Print() {
  internalList->Print();
}