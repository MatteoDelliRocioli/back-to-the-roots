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
#include <unordered_map>
//#include <tr1/unordered_map>

//using namespace std::tr1;

using namespace std;

bool solQuadratic(
	char *array1, size_t arr1Size, char *array2, size_t arr2Size);

bool solLinear(
	char *array1, size_t arr1Size, char *array2, size_t arr2Size);

int main()
{
	//char array1[] {'a', 'b', 'c', 'x'};
	//char array2[] {'z', 'y', 'i'};
	char array1[] {'a', 'b', 'c', 'x'};
	char array2[] {'z', 'y', 'x'};

	size_t array1Size = sizeof(array1)/sizeof(array1[0]);
	size_t array2Size = sizeof(array2)/sizeof(array2[0]);

	bool result {false};

	/*The most bruteforce approach would be to iterate the two arrays and
	 then return as soon there is a common item
	 this would be a quadratic time solution and constant space solution*/
	//result = solQuadratic(array1, array1Size, array2, array2Size);

	/*A more efficient approach would be to use a hash table, that would
	 * mean that we have to loop the first array to populate the hash
	 * table, then loop the second array to look for any match with first
	 * array. Since the look up operation on hash table (unordered_map in
	 * cpp) is constant time, we would finally have two separate
	 * loops meaning a O(a + b) solution time complexity*/
	result = solLinear(array1, array1Size, array2, array2Size);

	if (result)
	{
		cout << "equal present" << endl;
	}

	return 0;
}


bool solQuadratic(
	char *array1, size_t arr1Size, char *array2, size_t arr2Size)
{
	bool result {false};

	for (size_t i {0}; i < arr1Size; i++)
	{
		for (size_t j {0}; j < arr2Size; j++)
		{
			if (array1[i] == array2[j])
			{
				result = true;
				return result;
			}
		}
	}

	return result;
}

/*A more efficient approach would be to use a hash table, that would
 * mean that we have to loop the first array to populate the hash
 * table, then loop the second array to look for any match with first
 * array. Since the look up operation on hash table (unordered_map in
 * cpp) is constant time, we would finally have two separate
 * loops meaning a O(a + b) solution time complexity*/
bool solLinear(
	char* array1, size_t arr1Size, char* array2, size_t arr2Size)
{
	bool result {false};

	//Create the hash table
	unordered_map<char, bool> arr1Map;

	for (size_t i {0}; i < arr1Size; i++)
	{
		arr1Map[array1[i]] = true;
	}

	for (auto &x : arr1Map)
	{
		cout << std::boolalpha;
		cout << x.first << " " << x.second << endl;
	}

	//for(auto x : (* array1))

	//loop the second array to look up for values

	return result;
}
