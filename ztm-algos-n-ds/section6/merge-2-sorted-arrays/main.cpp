#include <iostream>
#include <vector>

using namespace std;

/*
 * Given 2 sorted arrays merge them into one big sorted array
 *
 * Example data set:
 * int [] {4, 6, 30};
 * int [] {0, 3, 4, 31};
 * */

/*
 * A naive way of solving this problem would be to iterate the 2 inputs
 * while we compare the elements from the first array and the second
 * array starting both from left to right (smaller elements of each
 * array).
 * If the left element is lesser than the right one then we add it to
 * the new forming collection, otherwise we add the right one. Repeating
 * this comparizon with all the elements of the two arrays we will
 * eventually have a new merged sorted array.
 *
 * That would be O(n^2) solution, so certainly improvable
 * */
vector<int> mergeArrays(int *arr1, int a1S, int* arr2, int a2S);
void printCollection(int* arr, int arrLength);
void printCollection(vector<int> vec);

int main()
{
	int arr1[] {4, 5, 7, 9};
	int arr2[] {6, 8, 10};

	int arr1Size = sizeof(arr1)/sizeof(arr1[0]);
	int arr2Size = sizeof(arr2)/sizeof(arr2[0]);

	vector<int> mergedArray = mergeArrays(arr1, arr1Size, arr2, arr2Size);

	printCollection(mergedArray);

	return 0;
}

vector<int> mergeArrays(int* arr1, int a1S, int* arr2, int a2S)
{
	vector<int> result {};

	printCollection(arr1, a1S);
	printCollection(arr2, a2S);

	int resultSize = a1S + a2S;
	bool hasToInsertLeft {false};

	cout << "a1S: " << a1S << endl;
	cout << "a2S: " << a2S << endl;
	cout << "resultSize: " << resultSize << endl << endl;

	int i {0};
	int j {0};

	while (resultSize > 0)
	{
		if (i > a1S || arr1[i] < arr2[j])
			hasToInsertLeft = true;

		if (hasToInsertLeft)
		{
			result.push_back(arr1[i]);
			i++;
		}
		else
		{
			result.push_back(arr2[j]);
			j++;
		}

		cout << "i | arr1[i]: " << i << " | " << arr1[i] << endl;
		cout << "j | arr2[j]: " << j << " | " << arr2[j] << endl;
		cout << boolalpha;
		cout << "hasToInsertLeft: " << hasToInsertLeft << endl;

		hasToInsertLeft = false;
		resultSize--;
	}

	return result;
}

void printCollection(int* arr, int arrLength)
{
	cout << "[ ";
	for (int i{0}; i < arrLength; i++)
	{
		cout << arr[i] << " ";
	}
	cout << "]" << endl << endl;;
}

void printCollection(vector<int> vec)
{
	cout << "[ ";
	for (auto x : vec)
	{
		cout << x << " ";
	}
	cout << "]" << endl << endl;
}
