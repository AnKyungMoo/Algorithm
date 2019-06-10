#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main(void)
{
	int N;

	cin >> N;

	for (int i = 1; i <= N; ++i)
	{
		long long input;
		cin >> input;

		long result = 0;
		while (input != 1)
		{
			if (input % 2 == 0)
			{
				input /= 2;
				result++;
			}
			else if (input % 3 == 0)
			{
				input = input / 3 * 2;
				result++;
			}
			else if (input % 5 == 0)
			{
				input = input / 5 * 4;
				result++;
			}
			else
			{
				result = -1;
				break;
			}
		}

		cout << result << "\n";
	}

	return 0;
}