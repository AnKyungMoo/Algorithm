#include <iostream>
#include <string>
#define LENGTH 26

using namespace std;

int main(void)
{
	int alpha[LENGTH];
	string insert;

	for (auto i = 0; i < LENGTH; ++i)
	{
		alpha[i] = -1;
	}

	cin >> insert;

	for (auto i = 0; i < insert.size(); ++i)
	{
		if (alpha[insert[i] - 97] == -1)
		{
			alpha[insert[i] - 97] = i;
		}
	}

	for (auto i = 0; i < LENGTH; ++i)
	{
		cout << alpha[i] << " ";
	}

	return 0;
}