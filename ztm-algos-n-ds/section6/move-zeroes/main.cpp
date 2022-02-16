#include <iostream>
#include <vector>

using namespace std;

void moveZeroes(vector<int>& nums);
void printVector(const vector<int>& nums);

int main()
{
	vector<int> nums {0,1,0,3,12};

	moveZeroes(nums);

	return 0;
}

void moveZeroes(vector<int>& nums)
{
	int shift {0};
	int notZeroes {0};

	cout << "Original vector: ";
	printVector(nums);

	for (size_t i {0}; i < nums.size(); i++)
	{
		/*cout << "i: " << i << endl;
		cout << "Current number: " << nums.at(i) << endl;
		cout << "Shift: " << shift << endl;
		cout << boolalpha << endl;
		cout << "(notZeroes + shift)= " << (notZeroes + shift) << endl;
		cout << "nums size - 1: " << nums.size() - 1 << endl;
		cout << "(i + notZeroes) == (nums.size() - 1) = " << ((i + notZeroes) == (int)(nums.size() - 1)) << endl;*/

		if ((notZeroes + shift) == (nums.size()))
		{
			break;
		}

		if (nums.at(i) == 0)
		{
			shift++;
			continue;
		}
		
		notZeroes++;

		if (shift > 0)
		{
			nums.at(i - shift) = nums.at(i);
		}
	}

	for (size_t i {nums.size() - shift}; i < nums.size(); i++)
	{
		nums.at(i) = 0;
	}

	cout << "Moved zeroes vector: ";
	printVector(nums);
}

void printVector(const vector<int>& nums)
{
	cout << "[ ";
	for (int x: nums)
	{
		cout << x << " ";
	}
	cout << "]" << endl << endl;
}