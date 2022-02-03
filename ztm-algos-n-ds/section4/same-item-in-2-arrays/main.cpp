/*
Given 2 arrays, create a function that let's a user know (true/false)
	whether these two arrays contain any common items

For example:

const array1 = ['a', 'b', 'c', 'x'];
const array2 = ['z', 'y', 'i'];

should return false;
--------------------

const array1 = ['a', 'b', 'c', 'x'];
const array2 = ['z', 'y', 'x'];

should return true;
*/

#include <iostream>
#include <vector>

using namespace std;

bool solQuadratic(
	const vector<char> &array1, const vector<char> &array2);

int main()
{
	//The most bruteforce approach would be to iterate the two arrays and
	// then return as soon there is a common item
	// this would be a quadratic time solution and constant space solution

	//const vector<char> array1 {'a', 'b', 'c', 'x'};
	//const vector<char> array2 {'z', 'y', 'i'};
	const vector<char> array1 {'a', 'b', 'c', 'x'};
	const vector<char> array2 {'z', 'y', 'x'};

	bool result {false};

	result = solQuadratic(array1, array2);

	if (result)
	{
		cout << "equal present" << endl;
	}

	return 0;
}

bool solQuadratic(
	const vector<char> &array1, const vector<char> &array2)
{
	bool result {false};

	for (auto x : array1)
	{
		for (auto y : array2)
		{
			if (x == y)
			{
				result = true;
				return result;
			}
		}
	}

	return result;
}

