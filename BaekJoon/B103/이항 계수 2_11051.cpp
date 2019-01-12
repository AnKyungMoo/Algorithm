#include <iostream>

int d[1001][1001] = { 0, };

int main(void)
{
	int N, K;

	scanf("%d %d", &N, &K);

	d[0][0] = 1;

	for (auto i = 1; i <= N; ++i)
	{
		d[i][0] = 1;
		d[i][i] = 1;
	}

	for (auto i = 2; i <= N; ++i)
	{
		for (auto j = 1; j < i; ++j)
		{
			d[i][j] = (d[i - 1][j - 1] + d[i - 1][j]) % 10007;
		}
	}

	printf("%d", d[N][K]);

	return 0;
}