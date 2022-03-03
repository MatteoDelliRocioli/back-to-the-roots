#include "stack.h"
#include "linked_list.h"
#include <iostream>

using namespace std;

int main() {
  LinkedList* myLinkedList = new LinkedList();

  myLinkedList->PushBack(1);
  myLinkedList->PushBack(2);
  myLinkedList->PushBack(3);
  myLinkedList->PushBack(4);

  myLinkedList->Print();

  cout << "Peeking last inserted element: " << myLinkedList->Peek() << endl;

  /*result = myLinkedList->tail->next;
  cout << "result: " << result << endl;*/
  return 0;
}