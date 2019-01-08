#include <iostream>
#include <algorithm>

struct Node
{
	int a;
	int b;
	int cost;
};

Node n[100001];
int parent[1001];

bool compare(Node a, Node b)
{
	return a.cost < b.cost;
}

int find(int a)
{
	if (parent[a] == a)
		return a;

	return parent[a] = find(parent[a]);
}

bool union_(int a, int b)
{
	int a_root = find(a);
	int b_root = find(b);

	if (a_root != b_root)
	{
		parent[a_root] = b_root;
		return true;
	}

	return false;
}

int main(void)
{
	int N, M;
	int result = 0;

	scanf("%d", &N);
	scanf("%d", &M);

	for (auto i = 1; i <= N; ++i)
	{
		parent[i] = i;
	}

	for (auto i = 1; i <= M; ++i)
	{
		scanf("%d %d %d", &n[i].a, &n[i].b, &n[i].cost);
	}

	std::sort(n + 1, n + M + 1, compare);

	int index = 1;
	for (auto i = 1; i < N;)
	{
		if (union_(n[index].a, n[index].b))
		{
			result += n[index].cost;
			i++;
		}
		index++;
	}

	printf("%d\n", result);

	return 0;
}