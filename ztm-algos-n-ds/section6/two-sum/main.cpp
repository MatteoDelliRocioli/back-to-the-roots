#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

vector<int> findPairSumUpToTarget(int *arr1, int aS, int target);

int main()
{
	int arr1 [] {1, 2, 7, 9, 3, 4};
	int target {12};
	int arr1Size = sizeof(arr1) / sizeof(arr1[0]);

	vector<int> result = findPairSumUpToTarget(arr1, arr1Size, target);

	cout << result.size() << endl;

	return 0;
}

vector<int> findPairSumUpToTarget(int *arr1, int aS, int target)
{
	vector<int> result {};

	unordered_set<int> aSet{{}};

	for (int i {0}; i < aS; i++)
	{
		aSet.insert(arr1[i]);
	}

	for (int i {0}; i < aS; i++)
	{
		int complement = target - arr1[i];

		auto got = aSet.find(complement);

		if (got != aSet.end())
		{
			cout << "Addends: " << *got << " + " << arr1[i] << " = " <<
				target << endl;
			//cout << "got: " << *got << endl;
		}

	}

	cout << aSet.size() << endl;

	return result;
}
