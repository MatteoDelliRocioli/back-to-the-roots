#include "linked_list.h"
#include <iostream>

using namespace std;

int main() {
  LinkedList* linked_list = NULL;

  linked_list = new LinkedList(1);

  linked_list->PushBack(2);
  linked_list->PushBack(3);
  linked_list->PushBack(4);
  linked_list->PushBack(5);

  linked_list->PrintElements();

  linked_list->Insert(9999, 1);

  linked_list->PrintElements();

  linked_list->Delete(1);

  linked_list->PrintElements();

  delete linked_list;

  return 0;
}