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
      return result;
    }

    currentNode = nextNode;
  }
  return INT_MIN;
}

LinkedList* LinkedList::Reverse() {
  //Instead of pointing to the next right node
  // point to the previous left node so that the resulting
  // linked list is the reversed version of the original
  Node* previous = NULL;
  Node* current = head;
  Node* nextNode = current->next;

  //head->next = NULL;

  if (nextNode->next != NULL) {

    cout << "current->next: " << current->next << endl;
    current->next = previous;
    cout << "current: " << current << endl;
    previous = current;
    cout << "previous: " << previous << endl;
    current = nextNode;
    cout << "current: " << current << endl;
    nextNode = nextNode->next;
    cout << "nextNode: " << nextNode << endl;
  }

  /*while (nextNode->next != NULL) {
    current->next = previous;
    previous = current;
    current = nextNode;
    nextNode = nextNode->next;
  }*/

  //nextNode->next = current;
  //head = nextNode;

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