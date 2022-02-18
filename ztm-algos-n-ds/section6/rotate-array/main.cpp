#include <iostream>
#include <vector>

using namespace std;

void rotate(vector<int>& nums, int k);

int main()
{
	vector<int> nums {1,2,3,4,5,6,7};
	int k {3};

	rotate(nums, k);

	return 0;
}


//We can take the last k elements from the array and copy them into
// a new array. The remaining part of the new array would be a copy of
// the original array elements (index from 0 to arr.length - k)
//
//That solution would be O(n) space complexity and O(n) time complexity
void rotate(vector<int>& nums, int k)
{
	vector<int> res;

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