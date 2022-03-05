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
  tail = newNode;
  return;
}

int LinkedList::Peek() {
  return tail->data;
}

int LinkedList::PopBack() {
  //We have to iterate from the head to the tail
  // and before pointing to the tail, we delete the tail and
  // set the previous node to have next = NULL

  if (head == tail) {
    return tail->data;
  }

  Node* currentNode = head;
  while (currentNode->next != NULL) {
    Node* nextNode = currentNode->next;

    if (nextNode == tail) {
      int result = nextNode->data;
      delete nextNode;
      currentNode->next = NULL;
      tail = currentNode;
      tail->next = NULL;
      return result;
    }

    currentNode = nextNode;
  }
  return INT_MIN;
}

void PrintLinkedListReversing(Node* previous, Node* current, Node* nextNode) {
  cout << "//---------------------------------------------//" << endl;

  if (previous != NULL) {
    cout << "previous: { address: " << previous << ", data: " << previous->data << " }" << endl;
  }
  else {
    cout << "previous is NULL" << endl;
  }

  if (current != NULL) {
    cout << "current: { address: " << current << ", data: " << current->data << " }" << endl;
  }
  else {
    cout << "current is NULL" << endl;
  }

  if (nextNode != NULL) {
    cout << "nextNode: { address: " << nextNode << ", data: " << nextNode->data << " }" << endl << endl;
  }
  else {
    cout << "nextNode is NULL" << endl;
  }
}

LinkedList* LinkedList::Reverse() {
  //Instead of pointing to the next right node
  // point to the previous left node so that the resulting
  // linked list is the reversed version of the original
  Node* previous = new Node();
  Node* current = head;
  Node* nextNode = current->next;

  PrintLinkedListReversing(previous, current, nextNode);

  tail = current;

  PrintLinkedListReversing(previous, current, nextNode);

  while (current->next) {
    previous = current;
    if (nextNode == NULL) {
      head = current;
      break;
    }
    current = nextNode;
    nextNode = current->next;
    current->next = previous;
    PrintLinkedListReversing(previous, current, nextNode);
  }

  PrintLinkedListReversing(previous, current, nextNode);

  cout << "head: " << head << endl;
  tail->next = NULL;

  cout << "head: " << head << endl;

  return this;
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
  cout << " }" << endl;
}