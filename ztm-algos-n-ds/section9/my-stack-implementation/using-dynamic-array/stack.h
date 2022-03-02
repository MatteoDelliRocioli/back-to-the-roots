#pragma once

#include <vector>

class Stack {
  public:
    std::vector<int> data;

    Stack();
    int Pick();
    void Push(int value);
    int Pop();
};