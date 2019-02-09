#include <iostream>

using namespace std;

int main(void)
{
	int d[10000] = {0, };
	int p[10000] = {0, };
	int n;

	cin >> n;

	for (auto i = 1; i <= n; ++i)
	{
		cin >> p[i];
	}

	for (auto i = 1; i <= n; ++i)
	{
		for (auto j = 1; j <= i; ++j)
		{
			d[i] = d[i] > (d[i - j] + p[j]) ? d[i] : d[i - j] + p[j];
		}
	}

	cout << d[n] << endl;

	return 0;
}