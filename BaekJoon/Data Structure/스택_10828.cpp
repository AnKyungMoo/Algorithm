#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	int arr[1000];
	int number;
	int index = 0;
	string command;

	cin >> number;

	for (auto i = 0; i < number; ++i)
	{
		cin >> command;

		if (command == "push")
		{
			int command_num;

			cin >> command_num;

			arr[index++] = command_num;
		}
		else if (command == "pop")
		{
			if (index == 0)
			{
				cout << "-1" << endl;
				continue;
			}
			cout << arr[--index] << endl;
		}
		else if (command == "size")
		{
			cout << index << endl;
		}
		else if (command == "empty")
		{
			if (index == 0)
			{
				cout << "1" << endl;
			}
			else
			{
				cout << "0" << endl;
			}
		}
		else if (command == "top")
		{
			if (index == 0)
			{
				cout << "-1" << endl;
				continue;
			}

			cout << arr[index - 1] << endl;
		}
	}

	return 0;
}