#include <iostream>
#include <sstream>

using namespace std;

int d[201][201] = { 0, };

int main(void)
{
	int N, M, K;
	string result = "";

	scanf("%d %d %d", &N, &M, &K);

	d[0][0] = 1;

	for (auto i = 1; i <= 200; ++i)
	{
		d[i][0] = 1;
		d[i][i] = 1;
	}

	for (auto i = 2; i <= 200; ++i)
	{
		for (auto j = 1; j < i; ++j)
		{
			d[i][j] = d[i - 1][j - 1] + d[i - 1][j];

			if (d[i][j] > 1000000000)
			{
				d[i][j] = 1000000000 + 1;
			}
		}
	}

	if (K > d[N + M][N])
	{
		printf("-1");
		return 0;
	}

	while (N > 0 && M > 0)
	{
		if (d[N + M - 1][N - 1] >= K)
		{
			result += "a";
			N--;
		}
		else
		{
			K = K - d[N + M - 1][M];
			result += "z";
			M--;
		}
	}

	for (auto i = 0; i < N; ++i)
	{
		result += "a";
	}

	for (auto i = 0; i < M; ++i)
	{
		result += "z";
	}

	cout << result;

	return 0;
}