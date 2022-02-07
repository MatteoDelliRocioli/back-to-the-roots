/*
 * Given a string write a function that reverses it and returns it back
 *
 * E.i. "Hi My name is Matteo" should be
 * "oettaM si eman yM iH"
 * */

#include <iostream>
#include <string>

using namespace std;

/*Since a string can be processed as an array of chars then we could
 * iterate the string backwords saving each element (char) in reverse
 * order in a new array with the same size of the original, returning it
 * at the end
 *
 * Since we iterate the array for its length then the time complexity
 * would be linear (O(n))
 * Since we are concatenating a string with same length of the input,
 * the space complexity would also be linear
 * */
string reverseString(string string);

int main()
{
	string stringInput;

	cout << "Please insert a string to reverse: ";
	getline(cin, stringInput);

	cout << stringInput << endl;

	string reversedString = reverseString(stringInput);

	cout << reversedString << endl;

	return 0;
}

string reverseString(string input)
{
	string result = "";

	for (int i {static_cast<int>(input.length() - 1)}; i > -1; i--)
	{
		//cout << i << " | " << input.length() << endl;
		//cout << result << endl;
		result += input[i];
	}

	return result;
}
