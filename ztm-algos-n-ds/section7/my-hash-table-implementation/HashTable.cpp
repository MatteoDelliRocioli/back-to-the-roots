#include "HashTable.h"

using namespace personalImplementation;
using namespace std;

HashTable()
{
	cout << "Created hashTable obj" << endl;
}

~HashTable()
{
	cout << "Destroyed hashTable obj" << endl;
}

/*void HashTable::_hash(string key)
{
	long long hash {};

	for (int i {0}; i < (int)key.size(); i++)
	{
		hash = (hash + key[i] * i) % data.size();
	}
	return hash;

	/*let hash = 0;
	for (let i =0; i < key.length; i++){
			hash = (hash + key.charCodeAt(i) * i) % this.data.length
	}
	return hash;*/
}*/