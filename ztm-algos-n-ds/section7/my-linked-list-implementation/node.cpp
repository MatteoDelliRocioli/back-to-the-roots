#include "node.h"
#include <iostream>

using namespace std;

node::node()
{
	cout << "Created node with no value yet" << endl;
}

node::node(int &value) : value(value), link(nullptr)
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

int* node::getLink()
{
	return this->link;
}