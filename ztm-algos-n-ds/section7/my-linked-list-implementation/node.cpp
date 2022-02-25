#include "node.h"
#include <iostream>

using namespace std;

node::node(const int &value)
{
	cout << "new node" << endl;
	cout << "value: " << value << endl;
	cout << "link: " << std::hex << &value << endl << endl;
}

node::~node()
{
	cout << "destroyed node" << endl;
}