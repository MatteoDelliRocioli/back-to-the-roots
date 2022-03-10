#include "binary_tree.h"
//#include "node.h"
#include <iostream>

using namespace std;

int main() {
  BinaryTree* myTree = new BinaryTree();

  myTree->Insert(3);
  myTree->Insert(2);
  myTree->Insert(5);
  myTree->Insert(4);
  myTree->Insert(6);
  myTree->Insert(1);
  myTree->Insert(-1);

  int dataToSearch = -1;
  bool result = myTree->LookUp(dataToSearch);

  cout << boolalpha << "is " << dataToSearch << " value found? " << result << endl;

  myTree->Remove(1);

  return 0;
}