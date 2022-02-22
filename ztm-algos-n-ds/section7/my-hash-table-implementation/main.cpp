#include "hashTable.h"
#include <iostream>

using namespace std;

int main()
{

	hashTable t (50);

	cout << "t.size: " << t.data.size() << endl << endl;

	t.set("test", 7);
	t.set("test", 1);
	t.set("test", 4);
	t.set("test", 342);
	t.set("test", 1000);
	t.set("test", 63);
	t.set("test", 5);
	return 0;
}