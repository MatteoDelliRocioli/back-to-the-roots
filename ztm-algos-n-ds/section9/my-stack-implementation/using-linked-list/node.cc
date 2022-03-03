#include "node.h"
#include <iostream>

using namespace std;

Node::Node(): data(0), next(NULL){
  cout << "created empty node" << endl;
}

Node::Node(int data): data(data), next(NULL) {
  cout << "created node with data: " << data << endl;
}