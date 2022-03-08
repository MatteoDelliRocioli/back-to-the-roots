#pragma once

#include "node.h"

class BinaryTree {
  public:
    BinaryTree();
    ~BinaryTree();
    void Insert(int data);
    //bool LookUp();
    //void Remove();

    Node* root;
};