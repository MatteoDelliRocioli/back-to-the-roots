#include "node.h"
#include <iostream>

using namespace std;

Node::Node() : left(NULL), right(NULL), data((int)INT_MIN) {
  cout << "Created empty node" << endl;
}

Node::Node(int data) : left(NULL), right(NULL), data(data) {
  cout << "Created node with data: " << data << endl;
}

Node::~Node() {
  cout << "Deleted node";

  if (data != INT_MIN) {
    cout << " with data: " << data;
  }

  cout << endl;
}