#include "stack.h"
#include "linked_list.h"
#include <iostream>

using namespace std;

int main() {
  LinkedList* myLinkedList = new LinkedList();

  myLinkedList->PushBack(1);
  myLinkedList->PushBack(2);
  myLinkedList->PushBack(3);

  myLinkedList->Print();

  /*result = myLinkedList->tail->next;
  cout << "result: " << result << endl;*/
  return 0;
}