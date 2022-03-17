#include <iostream>

// Given a number N return the index value of the Fibonacci sequence, where the
// sequence is:
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...

// The pattern of the sequence is that each value is the sum of the 2 previous
// values, that means that for N=5 -> 2+3

int FibonacciIterative(int valueToSearch);
int FibonacciRecursive(
  int valueToSearch, int i = 2, int parent = 1, int grandParent = 0);
//int FibonacciRecursive(int valueToSearch);

int main() {
  //int result = FibonacciIterative(8);
  int result = FibonacciRecursive(9);

  std::cout << "result: " << result << std::endl;
  return 0;
}

int FibonacciIterative(int valueToSearch) {
  int grandParent {0};
  int parent {1};

  if (valueToSearch == 0) {
    return 0;
  }

  if (valueToSearch == 1) {
    return 1;
  }

  int i {2};

  int current {grandParent + parent};

  std::cout << "current: " << current << std::endl;
  std::cout << "valueToSearch: " << valueToSearch << std::endl;

  while (valueToSearch > current) {
    std::cout << "before: " << grandParent << ", " << parent << ", " <<
      current << std::endl;

    grandParent = parent;
    parent = current;
    current = grandParent + parent;
    i++;

    std::cout << "after: " << grandParent << ", " << parent << ", " <<
      current << std::endl << std::endl;

    if (valueToSearch == current) {
      return i;
      break;
    }
  }

  return -1;
}

int FibonacciRecursive(int valueToSearch, int i, int parent, int grandParent) {
  if (valueToSearch == 0) {
    return 0;
  }

  if (valueToSearch == 1) {
    return 1;
  }

  int current {parent + grandParent};
  if (valueToSearch == current) {
    return i;
  }

  if (valueToSearch > current) {
    return FibonacciRecursive(valueToSearch, i + 1, current, parent);
  }

  return -1;
}