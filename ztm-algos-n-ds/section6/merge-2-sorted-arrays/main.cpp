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
 * We can iterate through the combined lenght of the two inputs and
 * check for each element who is the smallest and add it to the final
 * collection, which will be sorted
 * That would be O(n) solution
 * */
vector<int> mergeArrays(int *arr1, int a1S, int* arr2, int a2S);
void printCollection(int* arr, int arrLength);
void printCollection(vector<int> vec);

int main()
{
	int arr2[] {4, 5, 7, 9, 40};
	int arr1[] {6, 8, 20};

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
		bool hasOverflownLeftArr {i > (a1S - 1)};
		bool hasOverflownRightArr {j > (a2S - 1)};

		cout << boolalpha;
		cout << "--> " << i << " , " << j << endl;
		cout << "hasOverflownLeftArr ? " << hasOverflownLeftArr << endl;
		cout << "hasOverflownRightArr ? " << hasOverflownRightArr << endl;
		cout << "arr1[i] < arr2[j] ? " << (arr1[i] < arr2[j]) << endl;
		cout << "i | arr1[i]: " << i << " | " << arr1[i] << endl;
		cout << "j | arr2[j]: " << j << " | " << arr2[j] << endl;

		if (!hasOverflownLeftArr && arr1[i] < arr2[j])
			hasToInsertLeft = true;

		if (hasOverflownRightArr)
			hasToInsertLeft = true;

		if (hasToInsertLeft)
		{
			cout << "inserting left (" << arr1[i] << ")" << endl;
			result.push_back(arr1[i]);
			i++;
		}
		else
		{
			cout << "inserting right (" << arr2[j] << ")" << endl;
			result.push_back(arr2[j]);
			j++;
		}

		cout << "hasToInsertLeft: " << hasToInsertLeft << endl;
		cout << "//--------------------------------------------//" << endl;

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
