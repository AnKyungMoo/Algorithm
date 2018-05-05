#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(void)
{
	stack<char> previous;
	stack<char> next;
	string base_string;
	char command;
	int num;

	cin >> base_string;
	cin >> num;

	for (auto i = 0; i < base_string.size(); ++i)
	{
		previous.push(base_string[i]);
	}

	for (auto i = 0; i < num; ++i)
	{
		cin >> command;

		if (command == 'L' && previous.size() != 0)
		{
			next.push(previous.top());
			previous.pop();
		}
		else if (command == 'D' && next.size() != 0)
		{
			previous.push(next.top());
			next.pop();
		}
		else if (command == 'B' && previous.size() != 0)
		{
			previous.pop();
		}
		else if (command == 'P')
		{
			char insert;
			
			cin >> insert;

			previous.push(insert);
		}
	}

	while (!previous.empty())
	{
		next.push(previous.top());
		previous.pop();
	}

	while (!next.empty())
	{
		cout << next.top();
		next.pop();
	}

	return 0;
}