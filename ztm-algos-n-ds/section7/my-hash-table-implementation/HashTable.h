// #pragma once goes only in header file
// header files must not be compiled (pragma once in main error)
//constructor and destructors must have the same name as the class (case sensitive)

#pragma once

#include <vector>

class hashTable
{
	public:
		std::vector<int> data;

		hashTable();
		hashTable(int size);
		~hashTable();

		/* get(string key);
		void set(string key, int value);

	private:
		void _hash(string key);*/
};