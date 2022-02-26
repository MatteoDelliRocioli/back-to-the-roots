#include "myLinkedList.h"
#include "node.h"
#include <iostream>

using namespace std;

myLinkedList::myLinkedList()
{
  cout << "Creating myLinkedList" << endl;
}

myLinkedList::~myLinkedList()
{
  cout << "Destroyed myLinkedList" << endl;
}

void myLinkedList

/*void myLinkedList::insert(node &node)
{
  
}*/

//void myLinkedList::remove();

void myLinkedList::print()
{
  cout << "Printing linkedList" << endl;
  if (head.getLink() == nullptr && head.getValue() == INT_MIN)
  {
    cout << "linked list with no elements" << endl;
    return;
  }

  node *currentNode = &head;

  cout << "currentNode value: " << currentNode->getValue() << endl;
  /*cout << "[ ";
  while(currentNode.link != tail.link)
  {
    cout << currentNode.value << ", " << currentNode.link;
  }
  cout << " ]" << endl;*/
}