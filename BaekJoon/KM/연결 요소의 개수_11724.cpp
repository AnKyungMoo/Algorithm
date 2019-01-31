#include <iostream>
#include <set>

using namespace std;

int parent[1001];

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

	parent[a_root] = parent[b_root];
}

int main(void)
{
	int N, M;
	int a, b;
	set<int> s;

	scanf("%d %d", &N, &M);

	for (auto i = 1; i <= N; ++i)
	{
		parent[i] = i;
	}

	for (auto i = 1; i <= M; ++i)
	{
		scanf("%d %d", &a, &b);
		union_(a, b);
	}

	for (auto i = 1; i <= N; ++i)
	{
		s.insert(find(i));
	}

	printf("%d", s.size());

	return 0;
}