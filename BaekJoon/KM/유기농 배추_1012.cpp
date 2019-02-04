#include <iostream>

using namespace std;

int ground[52][52] = { 0, };

void dfs(int x, int y)
{
	if (ground[x][y] != 1)
	{
		return;
	}

	ground[x][y] = -1;

	dfs(x + 1, y);
	dfs(x - 1, y);
	dfs(x, y + 1);
	dfs(x, y - 1);
}

int main(void)
{
	int T;
	int M, N, K;
	int count = 0;

	scanf("%d", &T);

	for (auto t = 0; t < T; ++t)
	{
		scanf("%d %d %d", &M, &N, &K);
		count = 0;
		for (auto k = 0; k < K; ++k)
		{
			int x, y;
			scanf("%d %d", &x, &y);

			ground[x + 1][y + 1] = 1;
		}

		/* dfs */
		for (auto n = 1; n <= N; ++n)
		{
			for (auto m = 1; m <= M; ++m)
			{
				if (ground[m][n] == 1)
				{
					dfs(m, n);
					count++;
				}
			}
		}

		printf("%d\n", count);
	}

	return 0;
}