#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	string insert;
	int lower = 0, upper = 0, number = 0, space = 0;


	while (getline(cin, insert))
	{
		for (auto j = 0; j < insert.size(); ++j)
		{
			if (insert[j] >= 'a' && insert[j] <= 'z')
			{
				lower++;
			}
			else if (insert[j] >= 'A' && insert[j] <= 'Z')
			{
				upper++;
			}
			else if (insert[j] >= 48 && insert[j] <= 58)
			{
				number++;
			}
			else if (insert[j] == ' ')
			{
				space++;
			}
		}

		cout << lower << " " << upper << " " << number << " " << space << endl;
		
		lower = upper = number = space = 0;
	}

	return 0;
}