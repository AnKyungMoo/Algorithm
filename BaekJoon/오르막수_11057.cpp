#include <iostream>

using namespace std;

int main(void)
{
	int d[1001][10];
	int n;

	cin >> n;

	for (auto i = 0; i < 10; ++i)
	{
		d[1][i] = 1;
	}

	for (auto i = 2; i <= n; ++i)
	{
		for (auto j = 0; j < 10; ++j)
		{
			d[i][j] = 0;
			for (auto k = 0; k <=j; ++k)
			{
				d[i][j] += d[i - 1][k];
				d[i][j] %= 10007;
			}
		}
	}

	int result = 0;

	for (auto i = 0; i < 10; ++i)
	{
		result += d[n][i];
	}

	result %= 10007;

	cout << result << endl;

	return 0;
}