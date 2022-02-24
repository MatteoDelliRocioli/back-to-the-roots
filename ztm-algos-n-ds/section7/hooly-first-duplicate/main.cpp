#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

int firstRecurringNumber(const vector<int> vec);

int main ()
{
	vector<int> vec {2,5,5,2,3,5,1,2,4};
	int result = firstRecurringNumber(vec);

	cout << "result: " << result;

	return 0;
}

int firstRecurringNumber(const vector<int> vec)
{
	unordered_set<int> seenNumbers;

	for (int x : vec)
	{
		if (seenNumbers.find(x) != seenNumbers.end())
		{
			return x;
		}
		seenNumbers.insert(x);
	}

	return -1;
}