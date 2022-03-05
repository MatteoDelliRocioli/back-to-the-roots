#pragma once

class Node {
  public:
    Node();
    Node(int data);
    ~Node();

    int data;
    Node* next;
};