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
vector<int> twoSum01(vector<int>& nums, int target);
vector<int> twoSum_02(vector<int>& nums, int target);

int main()
{
	int target {11};
	vector<int> vec1 {-11,7,3,2,1,7,-10,11,21,3};

	printVector(vec1);

	vector<int> result = twoSum01(vec1, target);

	cout << "result: ";
	printVector(result);

	return 0;
}

vector<int> twoSum01(vector<int>& nums, int target)
{
	vector<int> result {};

	//value, index (index to return)
	unordered_map<int, int> compMap;

	for (int i {0}; i < static_cast<int>(nums.size()); i++)
	{
		int currentElement = nums.at(i);

		if (i == 0)
		{
			continue;
		}

		int complement = target - currentElement;
		cout << "at index i: " << i << endl;
		cout << target << " - " << currentElement << endl;
		cout << "complement: " << complement << endl << endl;

		auto got = compMap.find(complement);

		if (got != compMap.end() && got->second != i)
		{

			cout << "[ " << got->first << " " << got->second << " ]" << endl;
			cout << "complement: " << complement << endl;

			result.push_back(compMap[complement]);
			result.push_back(i);
			return result;
		}

		compMap.insert({currentElement, i});
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
