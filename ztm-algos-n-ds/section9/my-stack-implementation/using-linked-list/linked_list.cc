#include "linked_list.h"
#include "node.h"
#include <iostream>

using namespace std;

LinkedList::LinkedList() {
  cout << "created linked list" << endl;
  Node* node = new Node();
  head = tail = node;
}

void LinkedList::PushBack(int data) {
  cout << "here" << endl;

  if (head->next == NULL) {
    cout << "empty linked_list" << endl;
    //TODO: Add node to the list
  }

}