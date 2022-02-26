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

void myLinkedList::push_back(int &value)
{
  cout << "push_back value: " << std::dec << value << endl;
  cout << "push_back &value: " << std::hex << &value << endl;

  if (head.getLink() == nullptr && head.getValue() == INT_MIN)
  {
    head.setValue(value);
    head.setLink(value);

    cout << "here" << endl;
    return;
  }
  cout << "Assigning tail" << endl;

  node newNode(value);

  //cout << "tail link: " << tail.getLink() << endl;
  tail.setValue(value);
  tail.setLink(value);
  //cout << "tail link: " << tail.getLink() << endl;
}

/*void myLinkedList::insert(node &node)
{
  
}*/

//void myLinkedList::remove();

void myLinkedList::print()
{
  cout << "Printing linkedList: " << endl;
  if (head.getLink() == nullptr && head.getValue() == INT_MIN)
  {
    cout << "linked list is empty" << endl;
    return;
  }

  node *currentNode = &head;

  cout << "currentNode node value: " << std::dec << currentNode->getValue() << endl;
  cout << "currentNode node link: " << std::hex << currentNode->getLink() << endl;
  /*cout << "[ ";
  while(currentNode.link != tail.link)
  {
    cout << currentNode.value << ", " << currentNode.link;
  }
  cout << " ]" << endl;*/
}