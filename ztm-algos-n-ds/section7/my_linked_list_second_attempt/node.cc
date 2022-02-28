#include "node.h"
#include <iostream>
#include <cstddef>

using namespace std;

Node::Node() : data(0), next(NULL), previous(NULL) {
  cout << "created node" << endl;
}

Node::Node(int data) : next(NULL), previous(NULL) {
  this->data = data;
}

Node::~Node() {
  cout << "destroyed node" << endl;
  delete next;
}