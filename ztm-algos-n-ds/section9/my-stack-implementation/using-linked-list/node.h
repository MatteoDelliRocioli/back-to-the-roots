#pragma once

class Node {
  public:
    Node();
    Node(int data);

    int data;
    Node* next;
};