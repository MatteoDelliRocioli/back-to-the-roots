//https://www.youtube.com/watch?v=XKu_SEDAykw

/* Take notes
 * what are the inputs and the outputs?
 * do I have time and space constraints?
 * start with the naive brute approach, speack outloud to make your
 		tought process clear
 * observe and tell why the brute approach is not the best (i.e. O(n^2)
 		algorithm or higher, not readable etc...)
 * check your code for possible bugs (think about edge cases)
 * did you use all the information provided?
 * focus on the bottleneck (code with the greatest big O)
 *
 * while you code write down the steps you are going to follow
 * modularize your code right from the beginning
 * never start writing code unless you are sure how the things are going
 		to work
 * start with the easy part
 * tell that you would now write test to see if the code works properly
 * use meaningful variable names
 * go through your code outloud to test it live
 * propose different solutions, talk about what you would google, other
		interesting solutions that you didn't think about?
 * how would you change the solution if you would have to deal with
 		large inputs (too large to stay in memory)? // divide and conquer
 		approach
 * Communicate your thought process as much as possible
 * */

 /* The goal is to find a pair present in the array where the sum of
 * those is equal to a provided amount
 *
 * data sets:
 *
 * [1, 2, 3, 9] Sum = 8 -> no
 * [1, 2, 4, 4] Sum = 8 -> yes
 * */

/*A brute way of finding the solution would be to iterate the array two
 * times, one to get the first number to sum and the second time to see
 * if it can be summed up with any other element of the array to equal
 * the expexted sum value
 *
 * Since the array is sorted, a more efficient way to do this would be
 * to get two numbers, one called low and one called high.
 * The first being the smallest number in the collection and the latter
 * being the largest. Try to sum them to check if they sum up to more
 * than the target sum, if sum too large then move down of one index the
 * high otherwise move up of one index the low number.
 * The will eventually sum up to the target or cross each other
 * */
#include <iostream>
#include <unordered_set>

using namespace std;

bool sortedArrLinearSolve(int *arr, int arrSize, int sumTarget);
bool sortedArrLinearSolveV2(int *arr, int arrSize, int sumTarget);

bool unSortedArrLinearSolve(int *arr, int arrSize, int sumTarget);

int main()
{
	int array1 [] {1, 2, 3, 9, 4};
	//int array1 [] {1, 2, 4, 4};
	int sumTarget = 13;

	size_t arrSize = sizeof(array1) / sizeof(array1[0]);

	//bool result = sortedArrLinearSolve(array1, arrSize, sumTarget);
	//bool result = sortedArrLinearSolveV2(array1, arrSize, sumTarget);
	bool result = unSortedArrLinearSolve(array1, arrSize, sumTarget);

	cout << boolalpha << result << endl;

	return 0;
}

bool sortedArrLinearSolve(int *arr, int arrSize, int sumTarget)
{
	bool result {false};
	int low = 0;
	int high = arrSize - 1;

	if (arrSize < 1)
	{
		return result;
	}

	for (int i {0}; i < arrSize; i++)
	{
		int sum = arr[low] + arr[high];
		cout << "sum: " << sum << endl;
		cout << "sumTarget: " << sumTarget << endl;

		if (sum == sumTarget)
		{
			result = true;
			return result;
		}

		if (low == high)
		{
			return result;
		}

		if (sum < sumTarget)
		{
			low += 1;
		}

		if (sum > sumTarget)
		{
			high -= 1;
		}
	}

	return result;
}

bool sortedArrLinearSolveV2(int *arr, int arrSize, int sumTarget)
{
	int low = 0;
	int high = arrSize - 1;

	while(low < high)
	{
		int sum = arr[low] + arr[high];
		if(sum == sumTarget)
		{
			return true;
		}

		if (sum < sumTarget)
		{
			low += 1;
		}

		if (sum > sumTarget)
		{
			high -= 1;
		}
	}

	return false;
}

/*
 * If the array to compute is NOT parsed then we may look for every
 * element in the array one time and for each element populate an hash
 * table so that we can look if we already encountered the complement
 * (sumTarget - element) of the element itself
 * If yes then we know that a pair in the array sums up to the target
 *
 * The time complexity of this solution would be O(n) since we are
 * at worst iterating the array once and since the hash table look up
 * takes only constant time
 *
 * The space complexity would be linear as well (O(n)) since in the
 * worst case we are populating the hash table once with all the
 * elements of the input array. If that is the case than we know that
 * there is no pair that sums up to the target.
 * */
bool unSortedArrLinearSolve(int *arr, int arrSize, int sumTarget)
{
	unordered_set<int> complements;

	for (int i {0}; i < arrSize; i++)
	{

		int complementToSearch = sumTarget - arr[i];
		auto complement = complements.find(complementToSearch);

		if (complement != complements.end())
		{
			return true;
		}

		complements.insert(arr[i]);
	}

	return false;
}
