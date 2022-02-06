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
 * */
//char* reverseString(char* string, stringSize);

int main()
{
	string stringInput;

	cout << "Please insert a string to reverse: ";
	getline(cin, stringInput);

	cout << stringInput << endl;

	return 0;
}

//char* reverseString(char* string, stringSize)
//{

//}
