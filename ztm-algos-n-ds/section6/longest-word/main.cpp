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
		'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
		'0','1','2','3','4','5','6','7','8','9'
	};

	int i {0};
	int initCharIndex {0};
	int lastCharIndex {0};
	int longestStringSize {0};
	vector<string> res;

	cout << "(int)sen.size(): " << (int)sen.size() << endl;

	while(i < (int)sen.size())
	{
		if(validChars.find(sen[i]) != validChars.end())
		{
			i++;
			lastCharIndex = i;

			if (i < (int)sen.size())
			{
				continue;
			}
		}

		int currentStringLenght = lastCharIndex - initCharIndex;

		cout << "char: " << sen[i] << " ,i: " << i << endl;
		cout << "initCharIndex: " << initCharIndex << endl;
		cout << "lastCharIndex: " << lastCharIndex << endl;
		cout << "sen.substr(initCharIndex, (currentStringLenght)): " << sen.substr(initCharIndex, (currentStringLenght)) << endl;

		while(validChars.find(sen[i]) == validChars.end())
		{
			cout << "->" << i << endl;

			i++;
			
			if (i >= (int)sen.size())
			{
				break;
			}
		}
		i--;

		cout << "-->" << i << endl;

		//Check last inserted string length before inserting the string
		//if ((res.empty() || currentStringLenght >= res.at(0).size()) &&
		//	res.at(0).compare(sen.substr(initCharIndex, currentStringLenght)) != 0)
		if ((res.empty() || (int)currentStringLenght >= (int)res.at(0).size()))
		{
			if (!res.empty() && (int)currentStringLenght > (int)res.at(0).size())
			{
				res.clear();
			}

			res.push_back(sen.substr(initCharIndex, currentStringLenght));
		}
		
		if (i < (int)sen.size() - 1)
		{
			i++;
			initCharIndex = i;
		}

		cout << "//-------------------------------------//" << endl << endl;
	}

	printVector(res);

	return res.at(0);
}

int main(void) 
{
	// keep this function call here
	cout << LongestWord("I love dogs");
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