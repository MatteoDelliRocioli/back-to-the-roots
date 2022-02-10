#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/*
 * Given an array of ints, a way to find the pair that sums up to a
 * given target is to iterate the array in order to store its elements
 * in an unordered_map. By doing that we take trace of the seen elements
 * thus we can look up into them (in a costant time manner) when we are
 * searching for a complement of the next array element.
 * When we find a complement, we store its index and the current element's
 * index and then we return the collection.
 *
 * Given the above circumnstances, the time complexity would be O(n)
 * and the space complexity would be O(n) as well
 * */
vector<int> findPairSumUpToTarget(int *arr1, int aS, int target);
void printArr(int *arr1, int size);
void printVector(vector<int> vec);

vector<int> twoSum(vector<int>& nums, int target);

int main()
{
	//int arr1 [] {};
	//int arr1 [] {3, 2, 4};
	int target {11};
	//int arr1Size = sizeof(arr1) / sizeof(arr1[0]);

	vector<int> vec1 {-11,7,3,2,1,7,-10,11,21,3};

	//printArr(arr1, arr1Size);
	printVector(vec1);

	//vector<int> result = findPairSumUpToTarget(arr1, arr1Size, target);
	vector<int> result = twoSum(vec1, target);

	cout << "result: ";
	printVector(result);

	return 0;
}

vector<int> twoSum(vector<int>& nums, int target)
{
	vector<int> result {};

	unordered_map<int, int> compMap{{}};

	for (int i {0}; i < static_cast<int>(nums.size()); i++)
	{
		cout << "i: " << i << endl;

		compMap.insert({nums.at(i), i});

		//int complement {};
		//if (nums.at(i) < 0)
		//{
			//complement = target + nums.at(i);
		//}
		//else
		//{
			//complement = target - nums.at(i);
		//}

		int complement = target - nums.at(i);

		cout << "complement: " << complement << endl;

		auto got = compMap.find(complement);

		if (got != compMap.end())
		{
			cout << "got->first: " << (*got).first << endl;
			cout << "got->second: " << got->second << endl;
			cout << "arr1[i]: " << nums.at(i) << endl;
			cout << "i: " << i << endl;
		}

		if (got != compMap.end() && got->second != i)
		{
			result.push_back((*got).second);
			result.push_back(i);

			return result;
		}
	}

	return result;
}

vector<int> findPairSumUpToTarget(int *arr1, int aS, int target)
{
	vector<int> result {};

	unordered_map<int, int> compMap{{}};

	for (int i {0}; i < aS; i++)
	{

		cout << "i: " << i << endl;

		compMap.insert({arr1[i], i});

		int complement = target - arr1[i];

		cout << "complement: " << complement << endl;

		auto got = compMap.find(complement);

		if (got != compMap.end())
		{
			cout << "got->first: " << (*got).first << endl;
			cout << "got->second: " << got->second << endl;
			cout << "arr1[i]: " << arr1[i] << endl;
			cout << "i: " << i << endl;
		}

		if (got != compMap.end())
		{
			result.push_back((*got).second);
			result.push_back(i);

			return result;
		}
	}

	return result;
}

void printArr(int *arr1, int size)
{
	cout << "[ ";
	for (int i {0}; i < size; i++)
	{
		cout << arr1[i] << " ";
	}
	cout << "]" << endl;
}


void printVector(vector<int> vec)
{
	cout << "[ ";
	for (auto x : vec)
	{
		cout << x << " ";
	}
	cout << "]" << endl;
}
