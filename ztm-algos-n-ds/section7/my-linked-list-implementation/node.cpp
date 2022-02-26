#include "node.h"
#include <iostream>

using namespace std;

node::node() : value(INT_MIN), link(nullptr)
{
  cout << "Created node with no value yet" << endl;
}

node::node(int &value) : value(value), link(nullptr)
{
  cout << "new node with { ";
  cout << "value: " << value << ", ";
  cout << "link: " << std::hex << "nullptr" << " }" << endl << endl;
}

node::~node()
{
  cout << "destroyed node" << endl;
  this->link = nullptr;
}

int node::getValue()
{
  return this->value;
}

int* node::getLink()
{
  return this->link;
}

void node::setLink(int &link)
{
  //cout << "address link: " << &link << endl;
  this->link = &link; 
}