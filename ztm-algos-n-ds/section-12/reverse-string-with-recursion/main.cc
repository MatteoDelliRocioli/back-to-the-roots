#include <iostream>
#include <string>

using namespace std;

string ReverseStringIterative(string str);
string ReverseStringRecursive(string str);

int main() {
  //string result = ReverseStringIterative("miaooo!");
  string result = ReverseStringRecursive("miaooo!");

  cout << result << endl;

  return 0;
}

string ReverseStringIterative(string str) {
  int front {0};
  int back {(int)str.length() - 1};

  while (front < back) {
    char temp = str[back];
    str[back] = str[front];
    str[front] = temp;

    front++;
    back--;
  }

  return str;
}

/*string ReverseStringRecursive(string str) {
  int front {0};
  int back {(int)str.length()};

  if (str.length() < 2) {
    char temp = str[back];
    str[back] = str[front];
    str[front] = temp;
    return str;
  }

  if (front >= back) {
    char temp = str[back];
    str[back] = str[front];
    str[front] = temp;

    return ReverseStringRecursive(str.substr(front + 1,back - 1));
  }

  return str;
}*/

string ReverseStringRecursive(string str) {
  int front {0};
  int back {(int)str.length()};

  if (str.length() < 2) {
    return str;
  }

  return str[back] + ReverseStringRecursive(str.substr(1, str.length() - 2)) + str[front];
}
