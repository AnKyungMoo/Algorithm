#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	int deque[1000];
	int index = -1;
	int num;
	string command;

	cin >> num;

	for (auto i = 0; i < num; ++i)
	{
		cin >> command;

		if (command == "push_front")
		{
			int insert;

			cin >> insert;

			index++;
			for (auto j = index; j > 0; --j)
			{
				deque[j] = deque[j - 1];
			}

			deque[0] = insert;
		}
		else if (command == "push_back")
		{
			int insert;

			cin >> insert;

			deque[++index] = insert;
		}
		else if (command == "pop_front")
		{
			if (index == -1)
			{
				cout << -1 << endl;
				continue;
			}
			
			cout << deque[0] << endl;

			for (auto j = 0; j < index; ++j)
			{
				deque[j] = deque[j + 1];
			}
			index--;
		}
		else if (command == "pop_back")
		{
			if (index == -1)
			{
				cout << -1 << endl;
				continue;
			}

			cout << deque[index--] << endl;
		}
		else if (command == "size")
		{
			cout << index + 1 << endl;
		}
		else if (command == "empty")
		{
			if (index == -1)
			{
				cout << 1 << endl;
			}
			else
			{
				cout << 0 << endl;
			}
		}
		else if (command == "front")
		{
			if (index == -1)
			{
				cout << -1 << endl;
				continue;
			}

			cout << deque[0] << endl;
		}
		else if (command == "back")
		{
			if (index == -1)
			{
				cout << -1 << endl;
				continue;
			}

			cout << deque[index] << endl;
		}
	}

	return 0;
}