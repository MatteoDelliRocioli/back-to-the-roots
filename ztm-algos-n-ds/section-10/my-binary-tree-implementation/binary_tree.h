#pragma once

#include "node.h"
#include <cstddef>

class BinaryTree {
  public:
    BinaryTree();
    ~BinaryTree();
    void Insert(int data, Node* current = NULL);
    bool LookUp(int data, Node* current = NULL);
    void Remove(int data);

    Node* root;
};