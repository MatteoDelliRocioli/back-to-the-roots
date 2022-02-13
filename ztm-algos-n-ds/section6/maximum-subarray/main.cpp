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
	//vector<int> vec {-2,1,-3,4,-1,2,1,-5,4};
	vector<int> vec {-2,1,-3,4,-1,2,1,-5,-11,4};
	//vector<int> vec {-2,1,-3,4,-1,2,1,-5,4, -2, 6};

	printVector(vec);

	//int result = maxSubArray(vec);
	//int result = maxSubArray_01(vec);
	int result = maxSubArray_02(vec);

	cout << "result: " << result << endl;

	return 0;
}

int maxSubArray_02(vector<int>& nums)
{
	int i {0};

	while (i < (int)nums.size())
	{
		//loop positives
		while(i < (int)nums.size() && nums.at(i) > 0)
		{
			cout << "positive" << endl;
			i++;
		}

		//loop negatives
		while(i < (int)nums.size() && nums.at(i) < 0)
		{
			cout << "negative" << endl;
			i++;
		}
	}

	return 0;
}

int maxSubArray_01(vector<int>& nums)
{
	int vecSize = (int) nums.size();
	int low_left {0};
	int high_left {0};

	int tempSum {0};
	int sumLeft {0};

	vector<int> indexes {};

	if (vecSize == 0)
	{
		return 0;
	}

	if (vecSize == 1)
	{
		return nums.at(0);
	}

	//int lowExtremeFirstElement = INT_MIN;
	int highestNumber = nums.at(0);

	for (int i {0}; i < vecSize; i++)
	{
//1st block
		if (nums.at(i) > highestNumber)
		{
			highestNumber = nums.at(i);
		}

		if (nums.at(i) > 0)
		{
			low_left = i;

			while(nums.at(i) > 0)
			{
				cout << "adding " << nums.at(i) << endl;
				tempSum += nums.at(i);

				if (i == vecSize - 1)
				{
					break;
				}
				i++;
			}
			sumLeft = tempSum;
			tempSum = 0;
		}

		cout << endl << "sumLeft: " << sumLeft << endl;

		cout << "low_left: (index | value) " << low_left << " | " <<
			nums.at(low_left) << endl;
		cout << "high_left: (index | value) " << high_left << " | " <<
			nums.at(high_left) << endl;

		cout << "nums.at(i) after seen positives: " << nums.at(i) << endl;

//2nd block
		while (nums.at(i) < 0)
		{
			cout << nums.at(i) << endl;
			i++;
		}

		cout << "nums.at(i) after seen negatives: " << nums.at(i) << endl;

//3rd block
		//if (nums.at(i) > highestNumber)
		//{
			//highestNumber = nums.at(i);
		//}

		//if (nums.at(i) > 0)
		//{
			//low_left = i;

			//while(nums.at(i) > 0)
			//{
				//high_left = i;
				//if (i == vecSize - 1)
				//{
					//break;
				//}
				//i++;
			//}
		//}
	}

	cout << endl << "highestNumber: " << highestNumber << endl << endl;

	return 0;
}

int maxSubArray(vector<int>& nums)
{
	int vecSize = (int) nums.size();

	if (vecSize == 0)
	{
		return 0;
	}

	if (vecSize == 1)
	{
		return nums.at(0);
	}

	int lowExtremeFirstElement = INT_MIN;
	//int highExtremeLastElement = INT_MIN;
	int highestNumber = nums.at(0);

	//nums value, nums index
	//unordered_map<int, int> positiveStreakFirstElements;
	//nums index, nums value
	unordered_map<int, int> positiveStreakFirstElements;
	//unordered_map<int, int> highExtremeLastElement;

	for (int i {0}; i < vecSize; i++)
	{
		int currentElement = nums.at(i);

		if(currentElement > highestNumber)
		{
			highestNumber = currentElement;
		}

		if (currentElement > 0)
		{

			cout << endl << "positiveStreakFirstElements.size(): " <<
				positiveStreakFirstElements.size() << endl;

			lowExtremeFirstElement = currentElement;

			cout << "lowExtremeFirstElement: " << lowExtremeFirstElement
				<< endl;
			cout << "i: " << i << endl;

			positiveStreakFirstElements[i] = lowExtremeFirstElement;

			while(nums.at(i) > 0)
			{
				if (i == vecSize - 1)
				{
					break;
				}
				i++;
			}

			if (positiveStreakFirstElements.size() > 1 && i != vecSize - 1)
			{
				cout << "High extreme last number: " << nums.at(i - 1) << endl;
			}

		}

		if (nums.at(i) < 0)
		{
			cout << nums.at(i) << endl;
		}

	}

	//if ()

	printpositiveStreakFirstElements(positiveStreakFirstElements);

	return 0;
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
