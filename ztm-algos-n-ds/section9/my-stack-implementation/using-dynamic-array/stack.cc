#include "stack.h"
#include <vector>
#include <iostream>

using namespace std;

Stack::Stack () : data (vector<int> {}) {
  cout << "Stack created" << endl;
}

int Stack::Pick() {
  if (data.empty())
    return 0;

  return data.at(data.size() - 1);
}

void Stack::Push(int value) {
  data.push_back(value);
}

int Stack::Pop() {
  if (data.empty())
    return 0;
  int lastInserted = data.at(data.size() - 1);

  data.pop_back();

  return lastInserted;
}