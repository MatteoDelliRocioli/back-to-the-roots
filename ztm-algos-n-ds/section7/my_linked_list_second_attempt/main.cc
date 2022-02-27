#include "linked_list.h"
#include <iostream>

using namespace std;

int main() {
  LinkedList* linked_list = NULL;

  linked_list = new LinkedList();

  linked_list->Insert(1);
  linked_list->Insert(2);
  linked_list->Insert(3);

  delete linked_list;

  return 0;
}