#include "linked_list.h"
#include <iostream>
#include <cstddef>

using namespace std;

LinkedList::LinkedList() : head(new Node()) {
  cout << "LinkedList created" << endl;
}

LinkedList::LinkedList(int data) : head(new Node()) {
  cout << "LinkedList created with head->data: " << data << endl;
  head->data = data;
}

LinkedList::~LinkedList() {
  cout << "destroyed LinkedList" << endl;
  delete head;
}

void LinkedList::PushBack(int data) {
  cout << "PushBacking" << endl;
  cout << "head data: " << head->data << endl;

  /*if (head->next == NULL) {
    cout << "nope!" << endl;
    head->data = data;
  }*/

  Node* node = head;

  while (node->next != NULL) {
    cout << "here" << endl;
    node = node->next;
  }

  cout << "end of linked list" << endl;

  Node* newNode = new Node(data);

  cout << "NewNode address: " << newNode << endl;
  cout << "node->next: " << node->next << endl;
  cout << "newNode->previous: " << newNode->previous << endl;

  node->next = newNode;
  newNode->previous = node;

  cout << "node->next (after assign): " << node->next << endl;
  cout << "newNode->previous (after assign): " << newNode->previous << endl;
}

void LinkedList::Insert(int data, int index) {
  Node* node = head;

  while(node->next != NULL && index >= 1){
    if (index == 1) {
      Node* newNode = new Node(data);
      newNode->next = node->next;
      newNode->previous = node;
      node->next = newNode;

      Node* nextToNewNode = newNode->next;
      nextToNewNode->previous = newNode;

      break;
    }

    node = node->next;
    index--;
  }
}

void LinkedList::Delete(int index) {
  Node* node = head;

  if (index == 0 && head->next == NULL) {
    Node* node = new Node();
    head = node;
    return;
  }

  while (node->next != NULL && index >= 1) {
    if (index == 1) {
      Node* nextNode = node->next;
      Node* afterNextNode = nextNode->next;

      cout << "nextNode: " << nextNode << endl;
      cout << "afterNextNode: " << afterNextNode << endl;

      node->next = afterNextNode;
      //delete nextNode;
      break;
    }
    node = node->next;
    index--;
  }
}

void LinkedList::Prepend(int data) {
  Node* node = new Node(data);

  cout << "------------>node: " << node << endl;
  cout << "------------>node->next: " << node->next << endl;
  cout << "------------>head: " << head << endl;
  cout << "------------>head->next: " << head->data << endl;

  //head = node;

  node->next = head;
  head = node;
}

LinkedList* LinkedList::Reverse() {

  LinkedList* rev_list = new LinkedList();
  Node* currentNode = head;

  while (currentNode->next != NULL) {
    rev_list->Prepend(currentNode->data);
    currentNode = currentNode->next;
  }

  rev_list->Prepend(currentNode->data);

  return rev_list;
}

void LinkedList::PrintElements() {
  cout << "{ ";
  Node* node = head;

  while (node->next != NULL) {
    cout << "[ " << node->data << ", (" << node->next << ", " <<
      node->previous << ") ], ";
    node = node->next;
  }

  cout << "[ " << node->data << ", (" << node->next << ", " <<
    node->previous << ") ], ";

  cout << " }" << endl;
}