#include <iostream>
#include <vector>
#define INF 100000000

using namespace std;

int d[101][101];

int main(void)
{
	ios::sync_with_stdio(false);
	int n, m;
	int a, b, c;

	cin >> n;
	cin >> m;

	for (auto i = 1; i <= n; ++i)
	{
		for (auto j = 1; j <= n; ++j)
		{
			if (i == j)
				d[i][j] = 0;
			else
				d[i][j] = INF;
		}
	}

	for (auto i = 1; i <= m; ++i)
	{
		cin >> a >> b >> c;

		if (d[a][b] > c)
			d[a][b] = c;
	}

	for (auto k = 1; k <= n; ++k)
	{
		for (auto i = 1; i <= n; ++i)
		{
			for (auto j = 1; j <= n; ++j)
			{
				if (d[i][j] > d[i][k] + d[k][j])
				{
					d[i][j] = d[i][k] + d[k][j];
				}
			}
		}
	}

	for (auto i = 1; i <= n; ++i)
	{
		for (auto j = 1; j <= n; ++j)
		{
			if (d[i][j] == INF)
				cout << "0" << " ";
			else
				cout << d[i][j] << " ";
		}
		cout << "\n";
	}

	return 0;
}