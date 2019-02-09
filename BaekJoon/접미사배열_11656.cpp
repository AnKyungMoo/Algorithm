#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	string insert;
	vector<string> strings;

	cin >> insert;

	for (auto i = 0; i < insert.size(); ++i)
	{
		strings.push_back(insert.substr(i, insert.size() - i));
	}

	sort(strings.begin(), strings.end());

	for (auto i = 0; i < strings.size(); ++i)
	{
		cout << strings[i] << endl;
	}

	return 0;
}