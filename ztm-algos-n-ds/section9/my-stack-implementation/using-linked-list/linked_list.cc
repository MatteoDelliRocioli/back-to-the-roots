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

  Node* newNode = new Node(data);

  if (head->next == NULL && head->data == INT_MIN) {
    cout << "empty linked_list, adding the first node" << endl;
    head = newNode;
    tail = newNode;

    return;
  }

  if (head->next == NULL && head->data != INT_MIN) {
    cout << "one node list, adding one more node" << endl;
    head->next = newNode;
    tail = newNode;

    return;
  }

  cout << "More than 2 nodes in the list, adding one more" << endl;
  tail->next = newNode;
  return;
}

void LinkedList::Print() {
  Node* currentNode = head;

  cout << "{ ";
  cout << "[ data: " << currentNode->data << ", next: "
    << currentNode->next << " ],";
  while (currentNode->next != NULL) {
    currentNode = currentNode->next;
    cout << "[ data: " << currentNode->data << ", next: "
      << currentNode->next << " ],";
  }
  cout << " }";
}