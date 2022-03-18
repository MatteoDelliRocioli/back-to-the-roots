#include <iostream>
#include <string>

std::string ReverseStringIterative(std::string str);
void ReverseStringRecursive(std::string str);

int main() {
  std::string result = ReverseStringIterative("hey");

  std::cout << result << std::endl;

  return 0;
}

std::string ReverseStringIterative(std::string str) {
  int front {0};
  int back {(int)str.length() - 1};

  while (front < back) {
    //do something
    char temp = str[back];
    str[back] = str[front];
    str[front] = temp;

    front++;
    back--;
  }

  return str;
}

void ReverseStringRecursive(std::string str) {
  return;
}