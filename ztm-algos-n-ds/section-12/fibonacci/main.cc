#include <iostream>

// Given a number N return the index value of the Fibonacci sequence, where the
// sequence is:
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...

// The pattern of the sequence is that each value is the sum of the 2 previous
// values, that means that for N=5 -> 2+3

int FibonacciIterative(int valueToSearch);
int FibonacciRecursive(int valueToSearch);

int main() {
  int result = FibonacciIterative(7);
  //int result = FibonacciRecursive(7);

  std::cout << "result: " << result << std::endl;
  return 0;
}

int FibonacciIterative(int valueToSearch) {


  return 0;
}

int FibonacciRecursive(int valueToSearch) {
  return 0;
}