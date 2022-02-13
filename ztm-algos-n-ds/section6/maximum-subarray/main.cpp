#include <iostream>
#include <limits.h>
#include <vector>
#include <unordered_map>

using namespace std;

int maxSubArray(vector<int>& nums);
void printLowExtremeFirstElements(unordered_map<int, int> & map);
void printVector(vector<int>& nums);

int main()
{
	vector<int> vec {-2,1,-3,4,-1,2,1,-5,4};
	//vector<int> vec {-2,1,-3,4,-1,2,1,-5,4, -2, 6};
	printVector(vec);

	int result = maxSubArray(vec);

	cout << result << endl;

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
	//unordered_map<int, int> lowExtremeFirstElements;
	//nums index, nums value
	unordered_map<int, int> lowExtremeFirstElements;

	for (int i {0}; i < vecSize; i++)
	{
		int currentElement = nums.at(i);

		if(currentElement > highestNumber)
		{
			highestNumber = currentElement;
		}

		if (currentElement > 0)
		{
			lowExtremeFirstElement = currentElement;

			cout << "lowExtremeFirstElement: " << lowExtremeFirstElement
				<< endl;
			cout << "i: " << i << endl;

			lowExtremeFirstElements[i] = lowExtremeFirstElement;

			while(nums.at(i) > 0)
			{
				if (i == vecSize - 1)
				{
					break;
				}
				i++;
			}
			//if()
		}

		//if (currentElement < 0)
		//{
			//while(nums.at(i) < 0)
			//{
				//if (i == vecSize - 1)
				//{
					//break;
				//}
				//i++;
			//}
		//}

	}

	//if ()

	printLowExtremeFirstElements(lowExtremeFirstElements);

	return 0;
}

void printLowExtremeFirstElements(unordered_map<int, int>& map)
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
