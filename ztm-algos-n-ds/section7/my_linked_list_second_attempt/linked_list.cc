#include "linked_list.h"
#include <iostream>
#include <cstddef>

using namespace std;

LinkedList::LinkedList() : head(new Node()) {
  cout << "LinkedList created" << endl;
}

LinkedList::~LinkedList() {
  cout << "destroyed LinkedList" << endl;
  delete head;
}

void LinkedList::Insert(int data) {
  cout << "Inserting" << endl;
  cout << "head data: " << head << endl;

  Node* node = head;

  while (node->next != NULL) {
    cout << "here" << endl;
    node = node->next;
  }

  cout << "end of linked list" << endl;
}