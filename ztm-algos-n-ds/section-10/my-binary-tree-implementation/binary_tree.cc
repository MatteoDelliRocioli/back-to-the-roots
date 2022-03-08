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

void BinaryTree::Insert(int data, Node* current) {
  if (root->data == (int)INT_MIN) {
    cout << "binaryTree was empty, adding value to root" << endl;

    root->data = data;
    return;
  }

  cout << "current = (address: " << current << ")"<< endl;

  if (current == NULL) {
    cout << "current is NULL, starting from root then..." << endl;
    //Insert(data, new Node());
    current = root;
  }

  if (data == current->data) {
    return;
  }

  if (data > current->data) {
    cout << "going right" << endl;

    if (current->right == NULL) {
      cout << "inserting node right" << endl;
      Node* newNode = new Node(data);

      current->right = newNode;
      return;
    }

    cout << "keep searching where to insert with recursion (right)" << endl;
    Insert(data, current->right);

    return;
  }

  if (data < current->data) {
    cout << "going left" << endl;

    if (current->left == NULL) {
      cout << "inserting node left" << endl;
      Node* newNode = new Node(data);

      current->left = newNode;
      return;
    }

    cout << "keep searching where to insert with recursion (left)" << endl;
    Insert(data, current->left);

    return;
  }
}