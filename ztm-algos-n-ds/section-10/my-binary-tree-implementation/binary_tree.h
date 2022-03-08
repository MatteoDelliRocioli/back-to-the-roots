#pragma once

#include "node.h"
#include <cstddef>

class BinaryTree {
  public:
    BinaryTree();
    ~BinaryTree();
    void Insert(int data, Node* current = NULL);
    //bool LookUp();
    //void Remove();

    Node* root;
};