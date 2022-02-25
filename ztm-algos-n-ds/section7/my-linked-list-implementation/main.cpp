#include "node.h"
#include <iostream>

using namespace std;

int main()
{
	int value = 2;
	cout << "value address in main: " << std::hex << &value << endl;

	node n (value);
	return 0;
}