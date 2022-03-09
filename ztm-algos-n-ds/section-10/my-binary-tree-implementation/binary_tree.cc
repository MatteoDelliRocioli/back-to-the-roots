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

bool BinaryTree::LookUp(int data, Node* current) {
  if (current == NULL) {
    cout << "starting search from root" << endl;
    current = root;
  }

  if (data == current->data) {
    return true;
  }

  if (data < current->data && current->left != NULL) {
    return LookUp(data, current->left);
  }

  if (data > current->data && current->right != NULL) {
    return LookUp(data, current->right);
  }

  return false;
}

void BinaryTree::Remove(int data) {
  Node* current = root;
  Node* parent = root;

  if (data == current->data) {
    if (current->left == NULL && current->right == NULL) {
      cout << "root has no children, deleting it" << endl;

      root->data = INT_MIN;
    }
  }

  //Decide to go left or right

  if (data == current->data) {
    //Delete logic here

    //If node is leaf then we can remove it no problem
    if (current->left == NULL && current->right == NULL) {

    }

    //does the node has parents? 
    //if ()

    return;
  }

  if (data < current->data && current->left != NULL) {
    return Remove(data, current->left);
  }

  if (data > current->data && current->right != NULL) {
    return Remove(data, current->right);
  }

  return;

  return;
}