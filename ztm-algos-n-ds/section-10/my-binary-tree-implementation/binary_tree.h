#pragma once

#include "node.h"
#include <cstddef>
#include <tuple>

class BinaryTree {
  public:
    BinaryTree();
    ~BinaryTree();
    void Insert(int data, Node* current = NULL);
    bool LookUp(int data, Node* current = NULL);
    void Remove(int data, Node* current = NULL, Node* parent = NULL);

    Node* root;

  private:
    int FindNodeWithSmallestData(Node* current, Node* parent);
};