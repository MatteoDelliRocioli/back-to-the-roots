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
	data = vector<vector<int>> (size);
}

hashTable::~hashTable()
{
	cout << "Destroyed a hashtable obj" << endl;
}

int hashTable::_hash(string key)
{
	cout << "in hash generation: " << endl;
	long long hash {};

	for (int i {0}; i < (int)key.size(); i++)
	{
		cout << key[i] << endl;
		hash = (hash + (char)key[i] * i) % data.size();
	}
	cout << "hash: " << hash << endl << endl;

	cout << "//---------------------------------------------------//" << endl;

	return hash;
}

//We return the values associated to a particular index
// The index was initially decided by the _hash function
vector<int> hashTable::get(string key)
{
	//We first have to calculate the hash
	int index = _hash(key);

	return data[index];
}

//The data should be organized in a two dimensional matrix where one 
// collection is of keys and for each key (in the form of an hash) a collection of 
// ints is associated
void hashTable::set(string key, int value)
{
	cout << "hash: ";
	int index = _hash(key);
	cout << endl;

	data[index].push_back(value);

	cout << "here's the hashTable data: " << endl;

	int i {0};

	for (vector<int> x : data)
	{
		cout << i << " : " << "[ ";
		for (int y : x)
		{
			cout << y << ", ";
		}
		cout << "]" << endl;
		i++;
	}
}