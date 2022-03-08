#include "binary_tree.h"
#include "node.h"
#include <iostream>

using namespace std;

BinaryTree::BinaryTree() : root(new Node()) {
  cout << "created new binary tree" << endl;
}

BinaryTree::~BinaryTree() {
  cout << "deleting binary tree" << endl;
}

void BinaryTree::Insert(int data) {
  return;
}