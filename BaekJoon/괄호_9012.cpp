#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	int number;
	int stack_count = 0;

	cin >> number;

	for (auto i = 0; i < number; ++i)
	{
		string parenthesis;

		cin >> parenthesis;

		for (auto j = 0; j < parenthesis.size(); ++j)
		{
			if (parenthesis[j] == '(')
			{
				stack_count++;
			}
			else
			{
				if (stack_count == 0)
				{
					cout << "NO" << endl;
					break;
				}
				else
				{
					stack_count--;
				}
			}

			if (j == parenthesis.size() - 1)
			{
				if (stack_count == 0)
				{
					cout << "YES" << endl;
				}
				else
				{
					cout << "NO" << endl;
				}
			}
		}
		stack_count = 0;
	}

	return 0;
}