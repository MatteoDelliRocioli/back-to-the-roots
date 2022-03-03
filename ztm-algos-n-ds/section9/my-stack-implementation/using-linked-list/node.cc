#include "node.h"
#include <iostream>

using namespace std;

Node::Node(): data(INT_MIN), next(NULL){
  cout << "created empty node" << endl;
}

Node::Node(int data): data(data), next(NULL) {
  cout << "created node with data: " << data << endl;
}