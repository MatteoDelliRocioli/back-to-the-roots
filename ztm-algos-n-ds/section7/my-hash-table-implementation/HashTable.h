// #pragma once goes only in header file
// header files must not be compiled (pragma once in main error)
//constructor and destructors must have the same name as the class (case sensitive)

#pragma once

#include <vector>
#include <string>

class hashTable
{
	public:
		std::vector<std::vector<int>> data;

		hashTable();
		hashTable(int size);
		~hashTable();

		std::vector<int> get(std::string key);
		void set(std::string key, int value);

	private:
		int _hash(std::string key);
};