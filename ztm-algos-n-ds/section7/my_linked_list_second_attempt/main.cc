#include "linked_list.h"
#include <iostream>

using namespace std;

int main() {
  LinkedList* linked_list = NULL;

  linked_list = new LinkedList(1);

  linked_list->Insert(2);
  linked_list->Insert(3);
  linked_list->Insert(4);
  linked_list->Insert(5);

  linked_list->PrintElements();

  delete linked_list;

  return 0;
}