#include "stack.h"
#include "linked_list.h"
#include <iostream>

using namespace std;

int main() {
  LinkedList* myLinkedList = new LinkedList();

  myLinkedList->PushBack(4);

  /*result = myLinkedList->tail->next;
  cout << "result: " << result << endl;*/
  return 0;
}
