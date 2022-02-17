#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

bool containsDuplicate(vector<int>& nums);

int main()
{
	vector<int> vec {1,1,1,3,3,4,3,2,4,2};

	bool result = containsDuplicate(vec);

	cout << boolalpha;
	cout << result << endl;

	return 0;
}

bool containsDuplicate(vector<int>& nums)
{
	unordered_set<int> uS;

	for (int i {i}; i < (int)nums.size(); i++)
	{
		if (uS.find(nums.at(i)) != uS.end())
		{
			return true;
		}
		uS.insert(nums.at(i));
	}

	return false;
}