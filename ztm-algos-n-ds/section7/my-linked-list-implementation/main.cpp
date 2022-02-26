#include "node.h"
#include <iostream>

using namespace std;

int main()
{
	int value = 2;
	cout << "value address in main: " << std::hex << &value << endl;

	node n (value);

	int returnedValue = n.getValue();
	cout << "returnedValue: " << returnedValue << endl;

	int* returnedLinkToValue = n.getLink();
	cout << "returnedLinkToValue: " << returnedLinkToValue << endl;
	cout << "returnedLinkToValue_Value: " << (*returnedLinkToValue) << endl;

	return 0;
}