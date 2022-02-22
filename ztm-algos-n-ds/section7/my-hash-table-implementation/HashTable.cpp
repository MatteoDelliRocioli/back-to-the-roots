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

/*int get(string key)
{
	for (int i {0}; i < (int)data.size(); i++)
	{
		if ()
	}


	for (string x : data)
	{
		if (x == key)
		{
			return data
		}
	}
	return 0;
}*/

//The data should be organized in a two dimensional matrix where one 
// collection is of keys and for each key (in the form of an hash) a collection of 
// ints is associated
void hashTable::set(string key, int value)
{
	
}