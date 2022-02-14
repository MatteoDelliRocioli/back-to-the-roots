#include <iostream>
#include <limits.h>
#include <vector>
#include <unordered_map>

using namespace std;

int maxSubArray(vector<int>& nums);
void printpositiveStreakFirstElements(unordered_map<int, int> & map);
void printVector(vector<int>& nums);

int main()
{
	vector<int> vec {2, -1, 0, 0, -1, 2, 2, -2, 2};

	printVector(vec);

	int result = maxSubArray(vec);

	cout << "result: " << result << endl;

	cin.get();

	return 0;
}

int maxSubArray(vector<int>& nums)
{
	int i {0};
	int positiveSum {0};
	int secondStreakPositiveSum {0};
	int negativeStreakSum {0};
	int largestSum {INT_MIN};
	bool hasFoundMiddleNegatives {false};
	bool hasSecondPositiveStrike {false};
	int biggestNumber {INT_MIN};

	if (nums.size() > 0)
	{
		largestSum = nums.at(0);
		biggestNumber = nums.at(0);
	}

	while (i < static_cast<int>(nums.size()))
	{
		//loop positives
		while(i < static_cast<int>(nums.size()) && nums.at(i) >= 0)
		{
			 //If we already found positive numbers then we compare last positive
			 // streak sum with the next one
			 if (positiveSum > 0 && hasFoundMiddleNegatives)
			 {
				  secondStreakPositiveSum += nums.at(i);
				  hasSecondPositiveStrike = true;
			 }
			 else
			 {
				  positiveSum += nums.at(i);
			 }

				if (nums.at(i) > biggestNumber)
				{
					biggestNumber = nums.at(i);
				}
			 i++;
		}

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

		if ((positiveSum > 0 && secondStreakPositiveSum > 0) || hasSecondPositiveStrike)
		{
			positiveSum = positivesAndNegatives > secondStreakPositiveSum ?
				positivesAndNegatives : secondStreakPositiveSum;
			secondStreakPositiveSum = 0;
			hasSecondPositiveStrike = false;
		}

		//loop negatives
		hasFoundMiddleNegatives = false;
		negativeStreakSum = 0;
		while(i < static_cast<int>(nums.size()) && nums.at(i) < 0)
		{
			if (positiveSum > 0)
			{
				hasFoundMiddleNegatives = true;
			}
			negativeStreakSum += nums.at(i);
			if (nums.at(i) > biggestNumber)
			{
				biggestNumber = nums.at(i);
			}
			i++;
		}
	}

	if (biggestNumber != INT_MIN &&
		biggestNumber < largestSum &&
		biggestNumber <= 0)
	{
		largestSum = biggestNumber;
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
