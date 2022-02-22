#include "hashTable.h"
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{

	hashTable t (10);

	cout << "t.size: " << t.data.size() << endl << endl;

	string hashKey = "miao";

	t.set(hashKey, 7);
	t.set(hashKey, 1);
	t.set(hashKey, 4);
	t.set(hashKey, 342);
	t.set(hashKey, 1000);
	t.set(hashKey, 63);
	t.set(hashKey, 5);

	t.set("TT", 100000000);

	vector<int> toPrint = t.get(hashKey);

	cout << "retrieved data associated to '" << hashKey << "' => [ ";
	for (int x : toPrint)
	{
		cout << x << ", ";
	}
	cout << "]" << endl;
	return 0;
}