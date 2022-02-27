#include "node.h"
#include <iostream>
#include <cstddef>

using namespace std;

Node::Node() : data (0), next (NULL) {
  cout << "created node" << endl;
}

Node::Node(int data) : next (NULL) {
  this->data = data;
}

Node::~Node() {
  cout << "destroyed node" << endl;
  delete next;
}