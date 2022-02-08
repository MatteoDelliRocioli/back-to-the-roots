#include <iostream>

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
int[] mergeArrays(arr1, arr2);

int main()
{
	int arr1[] {4, 5, 7, 9};
	int arr2[] {6, 8, 10};

	int mergedArray[] = mergeArrays(arr1, arr2);

	return 0;
}

int [] mergeArrays(int* arr1, int a1S, int* arr2, int a2S)
{
	vector<int> result {};

	for (int i {0}; i < a1S; i++)
	{
		for (int j {0}; j < a2S; j++)
		{
			if (arr1[i] < arr2[j])
			{
				result.push_back(arr1[i]);
				i++;
			}
			else
			{
				result.push_back(arr2[j]);
				j++;
			}
		}
	}

	int resultSize = a1S + a2S;



	while (resultSize > 0)
	{
		if (i > a1S || )


		if (arr1[i] < arr2[j])
		{
			result.push_back(arr1[i]);
			i++;
		}
		else
		{
			result.push_back(arr2[j]);
			j++;
		}

		resultSize--;
	}
}
