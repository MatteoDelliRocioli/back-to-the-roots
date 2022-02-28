#pragma once

class Node {
  public:
    int data;
    Node* next;
    Node* previous;

    Node();
    Node(int data);
    ~Node();
};