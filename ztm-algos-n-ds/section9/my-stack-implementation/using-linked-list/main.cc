#include "stack.h"
#include "linked_list.h"
#include "stack.h"
#include <iostream>

using namespace std;

int main() {
  /*LinkedList* myLinkedList = new LinkedList();

  myLinkedList->PushBack(1);
  myLinkedList->PushBack(2);
  myLinkedList->PushBack(3);
  myLinkedList->PushBack(4);

  myLinkedList->Print();

  cout << "Peeking last inserted element: " << myLinkedList->Peek() << endl;

  myLinkedList->Print();

  myLinkedList->PopBack();

  myLinkedList->Print();

  myLinkedList->Reverse();

  myLinkedList->Print();*/

  Stack* myStack = new Stack();

  myStack->Push(1);
  myStack->Push(2);
  myStack->Push(3);
  myStack->Push(4);

  myStack->Print();
  cout << "First value to be popped in the stack: " << myStack->Peek() << endl;

  myStack->Print();
  cout << "Popping the last inserted element: " << myStack->Pop() << endl;

  myStack->Print();

  return 0;
}