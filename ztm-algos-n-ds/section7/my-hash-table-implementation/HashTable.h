// #pragma once goes only in header file
// header files must not be compiled (pragma once in main error)
//constructor and destructors must have the same name as the class (case sensitive)

#pragma once

class hashTable
{
	public:
		int n;

		hashTable();
		hashTable(int n);
		~hashTable();

		/* get(string key);
		void set(string key, int value);

	private:
		void _hash(string key);*/
};