#include <iostream>

int d[31][31] = { 0, };

int main(void)
{
	int T;
	int N, M;

	scanf("%d", &T);

	for (auto i = 0; i < T; ++i)
	{
		scanf("%d %d", &N, &M);

		d[0][0] = 1;

		for (auto i = 1; i <= M; ++i)
		{
			d[i][0] = 1;
			d[i][i] = 1;
		}

		for (auto i = 2; i <= M; ++i)
		{
			for (auto j = 1; j < i; ++j)
			{
				d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
			}
		}

		printf("%d\n", d[M][N]);
	}
	return 0;
}