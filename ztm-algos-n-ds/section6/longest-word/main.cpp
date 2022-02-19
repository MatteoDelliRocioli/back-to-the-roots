#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

void printVector(const vector<string>& vec);

string LongestWord(string sen) {

	// code goes here 
	unordered_set<char> validChars {
		'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','w','x','y','z',
		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','W','X','Y','Z'
	};

	vector<string> res;

	cout << boolalpha;
	cout << (validChars.find('a') != validChars.end()) << endl;

	int maxChars = 0;
	int currentMaxChars = 0;

	int initCharIndex = 0;
	int lastCharIndex = 0;

	bool isNewWord {false};

	for (int i {0}; i < (int)sen.size(); i++)
	{
		if(validChars.find(sen[i]) != validChars.end())
		{
			currentMaxChars++;
			lastCharIndex++;

			cout << boolalpha << "i: " << i << ", " << isNewWord << endl;

			if (isNewWord)
			{
				initCharIndex = i;
				isNewWord = false;
			}

			if ((i != (int)sen.size() -1))
			{
				continue;
			}
		}

		if ((currentMaxChars >= maxChars && currentMaxChars > 0) || (i == (int)sen.size() -1))
		{
			maxChars = currentMaxChars;
			res.push_back(sen.substr(initCharIndex, lastCharIndex));
		}

		isNewWord = true;
	}

	printVector(res);

	return sen;

}

int main(void) 
{
	// keep this function call here
	cout << LongestWord("example");
	//cout << LongestWord(coderbyteInternalStdinFunction(stdin));
	return 0;
}


void printVector(const vector<string>& vec)
{
	cout << "[ ";
	for (string x: vec)
	{
		cout << x << " ";
	}
	cout << "]" << endl;
}