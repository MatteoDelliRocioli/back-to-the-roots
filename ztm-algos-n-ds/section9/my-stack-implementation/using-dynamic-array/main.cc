#include "stack.h"
#include <iostream>

using namespace std;

int main() {

  Stack* stack = NULL;

  stack = new Stack();

  int picked = stack->Pick();

  cout << "picked: " << picked << endl;

  stack->Push(4);
  stack->Push(99);

  int popped = stack->Pop();

  cout << "popped: " << popped << endl;
  return 0;
}