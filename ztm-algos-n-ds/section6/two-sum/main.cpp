#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> findPairSumUpToTarget(int *arr1, int aS, int target);
void printArr(int *arr1, int size);
void printVector(vector<int> vec);

int main()
{
	//int arr1 [] {};
	int arr1 [] {1, 2, 7, 9, 4, 5, 3};
	int target {12};
	int arr1Size = sizeof(arr1) / sizeof(arr1[0]);

	printArr(arr1, arr1Size);

	vector<int> result = findPairSumUpToTarget(arr1, arr1Size, target);

	cout << "result: ";
	printVector(result);

	return 0;
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
