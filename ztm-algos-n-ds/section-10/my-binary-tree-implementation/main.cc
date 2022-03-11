#include "binary_tree.h"
//#include "node.h"
#include <iostream>

using namespace std;

int main() {
  BinaryTree* myTree = new BinaryTree();

  myTree->Insert(3);
  myTree->Insert(2);
  myTree->Insert(10);
  myTree->Insert(4);
  myTree->Insert(12);
  myTree->Insert(11);
  myTree->Insert(13);
  myTree->Insert(-1);

  /*
       3
      /  \
     2   10
    /    / \
   1    4   12
  /        /  \
-1        11   13
  */

  int dataToSearch = -1;
  bool result = myTree->LookUp(dataToSearch);

  cout << boolalpha << "is " << dataToSearch << " value found? " << result << endl;

  myTree->Remove(10);

  return 0;
}