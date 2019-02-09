#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	string insert;
	string result_string;

	getline(cin, insert);

	for (auto i = 0; i < insert.size(); ++i)
	{
		if (insert[i] >= 'a' && insert[i] <= 'z')
		{
			if (insert[i] + 13 > 'z')
				result_string += insert[i] - 13;
			else
				result_string += insert[i] + 13;
		}
		else if (insert[i] >= 'A' && insert[i] <= 'Z')
		{
			if (insert[i] + 13 > 'Z')
				result_string += insert[i] - 13;
			else
				result_string += insert[i] + 13;
		}
		else
		{
			result_string += insert[i];
		}
	}

	cout << result_string << endl;

	return 0;
}