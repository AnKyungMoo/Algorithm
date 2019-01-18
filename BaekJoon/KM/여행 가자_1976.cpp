#include <iostream>

using namespace std;

int parent[201];
int board[201][201];
int route[1001];

int find(int a)
{
	if (parent[a] == a)
		return a;

	return parent[a] = find(parent[a]);
}

void union_(int a, int b)
{
	int a_root = find(a);
	int b_root = find(b);

	parent[a_root] = b_root;
}

int main(void)
{
	int N, M;

	scanf("%d", &N);
	scanf("%d", &M);

	for (auto i = 1; i <= N; ++i)
	{
		parent[i] = i;
	}

	for (auto i = 1; i <= N; ++i)
	{
		for (auto j = 1; j <= N; ++j)
		{
			scanf("%d", &board[i][j]);
		}
	}

	for (auto i = 1; i <= N; ++i)
	{
		for (auto j = 1; j <= N; ++j)
		{
			if (board[i][j] == 1)
			{
				union_(i, j);
			}
		}
	}

	for (auto i = 1; i <= M; ++i)
	{
		scanf("%d", &route[i]);
	}

	for (auto i = 2; i <= M; ++i)
	{
		if (find(route[1]) != find(route[i]))
		{
			printf("NO\n");
			return 0;
		}
	}

	printf("YES\n");

	return 0;
}