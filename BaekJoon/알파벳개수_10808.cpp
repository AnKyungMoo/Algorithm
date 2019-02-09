#include <iostream>
#include <string>

#define LENGTH 26

using namespace std;

int main(void)
{
	int alpha[LENGTH] = {0, };
	string insert;

	cin >> insert;

	for (auto i = 0; i < insert.size(); ++i)
	{
		alpha[insert[i] - 97]++;
	}

	for (auto i = 0; i < LENGTH; ++i)
	{
		cout << alpha[i] << " ";
	}
	return 0;
}