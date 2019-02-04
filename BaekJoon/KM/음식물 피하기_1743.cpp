#include <iostream>
#include <algorithm>

using namespace std;

int board[101][101] = { 0, };

int dfs(int x, int y)
{
	int count = 0;

	if (board[x][y] != 1)
		return 0;

	board[x][y] = -1;
	count++;

	count += dfs(x, y + 1);
	count += dfs(x, y - 1);
	count += dfs(x + 1, y);
	count += dfs(x - 1, y);

	return count;
}

int main(void)
{
	int N, M, K;
	int result = 0;

	scanf("%d %d %d", &N, &M, &K);

	for (auto k = 0; k < K; ++k)
	{
		int x, y;

		scanf("%d %d", &x, &y);

		board[x][y] = 1;
	}

	for (auto n = 1; n <= N; ++n)
	{
		for (auto m = 1; m <= M; ++m)
		{
			result = max(dfs(n, m), result);
		}
	}

	printf("%d\n", result);

	return 0;
}