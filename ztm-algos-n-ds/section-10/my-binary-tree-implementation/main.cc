#include "binary_tree.h"
//#include "node.h"
#include <iostream>

using namespace std;

int main() {
  BinaryTree* myTree = new BinaryTree();

  myTree->Insert(3);
  myTree->Insert(2);
  myTree->Insert(4);

  return 0;
}