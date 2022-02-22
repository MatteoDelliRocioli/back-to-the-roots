#include "hashTable.h"
#include <iostream>
#include <vector>
#include <string>

using namespace std;

// Implementations of methods have to reference to the relative 
// header file with the syntax <header_name>::<method_name>
hashTable::hashTable()
{
	cout << "Created a new hashtable obj" << endl;
}

hashTable::hashTable(int size = 0)
{
	cout << "second type constructor called, size: " << size << endl;
	data = vector<int> (size);
}

hashTable::~hashTable()
{
	cout << "Destroyed a hashtable obj" << endl;
}

void hashTable::_hash(string key)
{
	cout << "in hash generation: " << endl;
	long long hash {};

	for (int i {0}; i < (int)key.size(); i++)
	{
		cout << key[i] << endl;
		hash = (hash + (char)key[i] * i) % data.size();
	}
	cout << "hash: " << hash << endl << endl;

	//return hash;
}

/*void hashTable::_hash(string key)
{
	long long hash {};

	for (int i {0}; i < (int)key.size(); i++)
	{
		hash = (hash + key[i] * i) % data.size();
	}
	return hash;

	let hash = 0;
	for (let i =0; i < key.length; i++){
			hash = (hash + key.charCodeAt(i) * i) % this.data.length
	}
	return hash;
}*/