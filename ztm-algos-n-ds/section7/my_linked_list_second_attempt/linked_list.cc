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
  cout << "head data: " << head->data << endl;

  Node* node = head;

  while (node->next != NULL) {
    cout << "here" << endl;
    node = node->next;
  }

  cout << "end of linked list" << endl;

  Node* newNode = new Node(data);

  cout << "NewNode address: " << newNode << endl;
  cout << "node->next: " << node->next << endl;

  node->next = newNode;

  cout << "node->next (after assign): " << node->next << endl;
}

void LinkedList::PrintElements() {
  cout << "{ ";
  Node* node = head;

  while (node->next != NULL) {
    cout << "[ " << node->data << ", " << node->next << " ], ";
    node = node->next;
  }

  cout << " }" << endl;
}