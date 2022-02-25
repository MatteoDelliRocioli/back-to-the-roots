#include "node.h"
#include <iostream>

using namespace std;

node::node(const int &value) : value(value), link(&value)
{
	cout << "new node" << endl;
	cout << "value: " << value << endl;
	cout << "link: " << std::hex << &value << endl << endl;
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

const int* node::getLink()
{
	return this->link;
}