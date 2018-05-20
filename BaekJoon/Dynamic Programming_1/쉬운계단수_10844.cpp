#include <iostream>

using namespace std;

int main(void)
{
	int d[101][10];
	int n;
	int sum = 0;

	cin >> n;

	d[1][0] = 0;

	for (auto i = 1; i < 10; ++i)
	{
		d[1][i] = 1;
	}

	for (auto i = 2; i <= n; ++i)
	{
		for (auto j = 0; j < 10; ++j)
		{
			if (j == 0)
			{
				d[i][j] = d[i - 1][j + 1] % 1000000000;
			}
			else if (j == 9)
			{
				d[i][j] = d[i - 1][j - 1] % 1000000000;
			}
			else
			{
				d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % 1000000000;
			}
		}
	}

	for (auto i = 0; i < 10; ++i)
	{
		sum += d[n][i];
	}

	cout << sum % 1000000000 << endl;

	return 0;
}