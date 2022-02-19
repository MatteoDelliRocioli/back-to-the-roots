#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

void printVector(const vector<string>& vec);

string LongestWord(string sen)
{
	// code goes here 
	unordered_set<char> validChars {
		'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','w','x','y','z',
		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','W','X','Y','Z'
	};

	int i {0};
	int initCharIndex {0};
	vector<string> res;

	while(i < (int)sen.size())
	{
		initCharIndex = i;
		while(validChars.find(sen[i]) != validChars.end())
		{
			cout << "char: " << sen[i] << " " << endl;
			i++;
		}

		cout << "char: " << sen[i] << " " << endl;
		res.push_back(sen.substr(initCharIndex, i));

		while(validChars.find(sen[i]) == validChars.end())
		{
			i++;
		}
	}

	printVector(res);

	return sen;
}

int main(void) 
{
	// keep this function call here
	cout << LongestWord("example/test//miao");
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