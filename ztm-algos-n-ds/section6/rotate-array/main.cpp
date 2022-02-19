#include <iostream>
#include <vector>

using namespace std;

void rotate(vector<int>& nums, int k);
void rotate_01(vector<int>& nums, int k);
void printVector(const vector<int>& nums);

int main()
{
	vector<int> nums {1,2,3,4,5,6,7};
	//vector<int> nums {-1};
	int k {3};
	rotate(nums, k);

	return 0;
}

void rotate(vector<int>& nums, int k)
{
	k = k % (int)nums.size();

	printVector(nums);

	vector<int> res;

	//We create a new empty vector result and start pushing to it
	// the last k elements and then we push the remaining elements of the original collection
	// from index 0(zero) to nums.size() - k
	for (int i {(int)nums.size() - k}; i < (int)nums.size(); i++)
	{
		res.push_back(nums.at(i));
	}

	for (int i {0}; i < ((int)nums.size() -k); i++)
	{
		res.push_back(nums.at(i));
	}

	printVector(res);

	nums = res;
	
	printVector(nums);
}

//We can take the last k elements from the array and copy them into
// a new array. The remaining part of the new array would be a copy of
// the original array elements (index from 0 to arr.length - k)
//
//That solution would be O(n) space complexity and O(n) time complexity
void rotate_01(vector<int>& nums, int k)
{
	vector<int> res;

	//Edge cases: what if k is more than nums.size() ?
	if (k > (int)nums.size())
	{
		k = k % (int)nums.size();
	}

	for (int i {(int)nums.size() - k}; i < (int)nums.size(); i++)
	{
		cout << nums.at(i) << " ";
		res.push_back(nums.at(i));
	}

	cout << endl << endl;

	for (int i {0}; i < ((int)nums.size() - k); i++)
	{
		cout << nums.at(i) << " ";
		res.push_back(nums.at(i));
	}

	nums = res;

	cout << endl << "res: ";
	for (int x : nums)
	{
		cout << x << " ";
	}
}

void printVector(const vector<int>& nums)
{
	cout << "[ ";
	for(int x: nums)
	{
		cout << x << " ";
	}
	cout << "]" << endl;
}