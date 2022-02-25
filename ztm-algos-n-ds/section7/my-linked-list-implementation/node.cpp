#include "node.h"
#include <iostream>

using namespace std;

node::node()
{
	cout << "new node" << endl;
}

node::~node()
{
	cout << "destroyed node" << endl;
}