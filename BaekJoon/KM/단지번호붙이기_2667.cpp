#include <iostream>
#include <algorithm>

using namespace std;

char board[27][27] = { 0, };

int dfs(int x, int y)
{
	if (board[x][y] != '1') return 0;

	int sum = 1;

	board[x][y] = '2';

	sum += dfs(x + 1, y);
	sum += dfs(x - 1, y);
	sum += dfs(x, y + 1);
	sum += dfs(x, y - 1);

	return sum;
}

int main(void)
{
	int N;
	int index = 0;
	int arr[625] = { 0, };

	scanf("%d", &N);

	for (auto i = 1; i <= N; ++i)
	{
		for (auto j = 1; j <= N; ++j)
		{
			cin >> board[i][j];
		}
	}

	for (auto i = 1; i <= N; ++i)
	{
		for (auto j = 1; j <= N; ++j)
		{
			if (board[i][j] == '1')
			{
				arr[index++] = dfs(i, j);
			}
		}
	}

	printf("%d\n", index);

	sort(arr, arr + index);

	for (auto i = 0; i < index; ++i)
	{
		printf("%d\n", arr[i]);
	}

	return 0;
}