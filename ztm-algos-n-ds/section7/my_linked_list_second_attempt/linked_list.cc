#include "linked_list.h"
#include <iostream>
#include <cstddef>

using namespace std;

LinkedList::LinkedList() : head(NULL) {
  cout << "LinkedList created" << endl;
}

LinkedList::~LinkedList() {
  cout << "destroyed LinkedList" << endl;
}

void LinkedList::Insert(int data) {
  Node* node = head;

  while (node->next != NULL) {
    cout << "here" << endl;
    node = node->next;
  }

  cout << "end of linked list" << endl;
}