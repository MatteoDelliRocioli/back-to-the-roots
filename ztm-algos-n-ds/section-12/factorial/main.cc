#include <iostream>

int FindFactorialRecursive(int number);
int FindFactorialForLoop(int number);

int main() {
  int result {FindFactorialForLoop(7)};

  std::cout << "result: " << result << std::endl;

  int resultFromRecursion {FindFactorialRecursive(7)};

  std::cout << "resultFromRecursion: " << resultFromRecursion << std::endl;

  return 0;
}

int FindFactorialRecursive(int number) {
  if (number == 0) {
    return 1;
  }

  if (number >= 1) {
    //std::cout << number << std::endl;
    return number * FindFactorialRecursive(number - 1);
  }

  return 0;
}

int FindFactorialForLoop(int number) {
  int result {1};

  if (number == 0) {
    return result;
  }

  while (number > 1) {
    //std::cout << number << std::endl;
    result *= number;
    number--;
  }

  return result;
}