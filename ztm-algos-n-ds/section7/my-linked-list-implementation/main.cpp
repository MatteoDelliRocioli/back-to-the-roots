#include "node.h"
#include "myLinkedList.h"
#include <iostream>

using namespace std;

int main()
{
  /*int value = 2;
  cout << "value address in main: " << std::hex << &value << endl;

  node n (value);

  int returnedValue = n.getValue();
  cout << "returnedValue: " << returnedValue << endl;

  int* returnedLinkToValue = n.getLink();
  cout << "returnedLinkToValue: " << returnedLinkToValue << endl;
  cout << "returnedLinkToValue_Value: " << (*returnedLinkToValue) << endl;

  //--------------------------------------------------------------------//
  int value {6};
  cout << "value address in main: " << std::hex << &value << endl;

  node n (value);

  cout << "n->link: " << n.getLink() << endl;
  n.setLink(value);
  cout << "n->link: " << n.getLink() << endl;

  //--------------------------------------------------------------------//
  */

  int newValue = 26;
  cout << "value address in main: " << std::hex << &newValue << endl;

  myLinkedList linkedList;

  linkedList.print();

  linkedList.push_back(newValue);

  linkedList.print();

  cout << "New head link: " << linkedList.head.getLink() << endl;

  return 0;
}