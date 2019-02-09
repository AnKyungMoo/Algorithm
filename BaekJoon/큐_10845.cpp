#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	int queue[1000];
	int index = -1;
	int num;
	string command;

	cin >> num;

	for (auto i = 0; i < num; ++i)
	{
		cin >> command;

		if (command == "push")
		{
			int insert;

			cin >> insert;

			queue[++index] = insert;
		}
		else if (command == "pop")
		{
			if (index == -1)
			{
				cout << -1 << endl;
				continue;
			}
			cout << queue[0] << endl;

			for (auto j = 0; j < index; ++j)
			{
				queue[j] = queue[j + 1];
			}
			index--;
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
			cout << queue[0] << endl;
		}
		else if (command == "back")
		{
			if (index == -1)
			{
				cout << -1 << endl;
				continue;
			}
			cout << queue[index] << endl;
		}
	}

	return 0;
}