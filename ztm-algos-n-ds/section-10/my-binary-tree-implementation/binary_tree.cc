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
  if (root->data == (int)INT_MIN) {
    cout << "binaryTree was empty, adding value to root" << endl;

    root->data = data;
    return;
  }

  if (data == root->data) {
    return;
  }

  if (data > root->data) {
    cout << "going right" << endl;
    return;
  }

  if (data < root->data) {
    cout << "going left" << endl;
    return;
  }
}