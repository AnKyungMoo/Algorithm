#include <iostream>

int parent[1000001];

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

	if (a_root != b_root)
	{
		parent[a_root] = b_root;
	}
}

int main(void)
{
	int n, m;
	int insert, a, b;

	scanf("%d %d", &n, &m);

	for (auto i = 0; i <= n; ++i)
	{
		parent[i] = i;
	}

	for (auto i = 0; i < m; ++i)
	{
		scanf("%d %d %d", &insert, &a, &b);

		if (insert == 0)
		{
			union_(a, b);
		}
		else if (insert == 1)
		{
			if (find(a) == find(b))
				printf("YES\n");
			else
				printf("NO\n");
		}
	}

	return 0;
}