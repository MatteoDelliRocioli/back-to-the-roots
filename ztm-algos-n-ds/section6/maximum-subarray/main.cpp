#include <iostream>
#include <limits.h>
#include <vector>
#include <unordered_map>

using namespace std;

int maxSubArray(vector<int>& nums);
int maxSubArray_01(vector<int>& nums);
int maxSubArray_02(vector<int>& nums);
void printpositiveStreakFirstElements(unordered_map<int, int> & map);
void printVector(vector<int>& nums);

int main()
{
	vector<int> vec {-2,1,-3,4,-1,2,1,-5,4};
	//vector<int> vec {1};
	//vector<int> vec {-2,1,-3,4,-1,2,1,-5,-11,4};
	//vector<int> vec {5,4,-1,7,8};
	//vector<int> vec {-2,1,-3,4,-1,2,1,-5,4, -2, 6};

	printVector(vec);

	//int result = maxSubArray(vec);
	//int result = maxSubArray_01(vec);
	int result = maxSubArray_02(vec);

	cout << "result: " << result << endl;

	cin.get();

	return 0;
}

int maxSubArray_02(vector<int>& nums)
{
	int i {0};
	int positiveSum {0};
	int secondStreakPositiveSum {0};
	int negativeStreakSum {0};
	int initialPositiveIndex_left {-1};
	int lastPositiveIndex_left {-1};
	//int initialPositiveIndex_right {-1};
	//int lastPositiveIndex_right {-1};
	int largestSum {INT_MIN};
	bool hasFoundMiddleNegatives {false};

	if (nums.size() > 0)
	{
		largestSum = nums.at(0);
	}

	while (i < (int)nums.size())
	{
		//loop positives
		if (nums.at(i) > 0)
		{
			initialPositiveIndex_left = i;
		}

		while(i < (int)nums.size() && nums.at(i) > 0)
		{
			cout << "positive: " << nums.at(i) << endl << endl;

			//If we already found positive numbers then we compare last positive
			// streak sum with the next one
			if (positiveSum > 0 && hasFoundMiddleNegatives)
			{
				secondStreakPositiveSum += nums.at(i);
			}
			else
			{
				positiveSum += nums.at(i);
			}
			lastPositiveIndex_left = i;
			i++;
		}

		cout << "initialPositiveIndex_left: " << initialPositiveIndex_left << endl;
		cout << "lastPositiveIndex_left: " << lastPositiveIndex_left << endl;

		cout << "positiveSum: " << positiveSum << endl;
		cout << "secondStreakPositiveSum: " << secondStreakPositiveSum
			<< endl;

		//Check if summing extremes and middle negative numbers we obtain a
		// result greater than each one of the single positive extremes
		// taken alone
		if (positiveSum > 0 || secondStreakPositiveSum > 0)
		{
			int newLargest = positiveSum > secondStreakPositiveSum ?
				positiveSum : secondStreakPositiveSum;

			if (newLargest > largestSum)
			{
				largestSum = newLargest;
			}
		}

		int positivesAndNegatives =
			positiveSum + negativeStreakSum + secondStreakPositiveSum;

		int newLargest = positivesAndNegatives;

		if (newLargest > largestSum)
		{
			largestSum = newLargest;
		}

		if (positiveSum > positivesAndNegatives &&
			positiveSum > secondStreakPositiveSum &&
			positiveSum > largestSum)
		{
			largestSum = positiveSum;
		}

		if (secondStreakPositiveSum > positivesAndNegatives &&
			secondStreakPositiveSum > positiveSum &&
			secondStreakPositiveSum > largestSum)
		{
			largestSum = secondStreakPositiveSum;
		}

		cout << "largestSum: " << largestSum << endl;

		if (positiveSum > 0 && secondStreakPositiveSum > 0)
		{
			positiveSum = secondStreakPositiveSum;
			secondStreakPositiveSum = 0;
		}

		//loop negatives
		hasFoundMiddleNegatives = false;
		negativeStreakSum = 0;
		while(i < (int)nums.size() && nums.at(i) < 0)
		{
			hasFoundMiddleNegatives = true;
			cout << "negative: " << nums.at(i) << endl << endl;
			negativeStreakSum += nums.at(i);
			i++;
		}

		cout << "negativeStreakSum: " << negativeStreakSum << endl;

		cout << "--------------------------------------------" << endl;
	}

	return largestSum;
}

void printpositiveStreakFirstElements(unordered_map<int, int>& map)
{
	cout << "[ ";
	for (auto x : map)
	{
		cout << "{" << x.first << "," << x.second << "} ";
	}
	cout << "]" << endl << endl;
}

void printVector(vector<int>& nums)
{
	cout << "[ ";
	for (auto x : nums)
	{
		cout << x << ", ";
	}
	cout << "]" << endl << endl;
}

//TODO: handle when all elements are negative numbers
//TODO: handle when only one positive number
