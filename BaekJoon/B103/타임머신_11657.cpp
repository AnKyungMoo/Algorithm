#include <iostream>
#include <vector>
#define INF 60000001

using namespace std;

struct Node
{
	int number;
	int cost;
};

vector<Node> graph[501];
int vertex[501] = { 0, };
int cycle[501];

int main(void)
{
	ios::sync_with_stdio(false);
	int N, M;
	int A, B, C;
	bool is_cycle = false;

	cin >> N >> M;

	for (auto i = 0; i < M; ++i)
	{
		cin >> A >> B >> C;

		graph[A].push_back({ B, C });
	}

	for (auto i = 1; i <= N; ++i)
	{
		vertex[i] = INF;
	}

	vertex[1] = 0;

	for (auto n = 1; n < N; ++n)
	{
		for (auto i = 1; i <= N; ++i)
		{
			for (auto g : graph[i])
			{
				if (vertex[i] == INF)
				{
					continue;
				}
				if (vertex[g.number] > vertex[i] + g.cost)
				{
					vertex[g.number] = vertex[i] + g.cost;
				}
			}
		}
	}

	for (auto i = 1; i <= N; ++i)
	{
		cycle[i] = vertex[i];
	}

	for (auto i = 1; i <= N; ++i)
	{
		for (auto g : graph[i])
		{
			if (cycle[i] == INF)
			{
				continue;
			}

			if (cycle[g.number] > cycle[i] + g.cost)
			{
				cycle[g.number] = cycle[i] + g.cost;
			}
		}
	}

	for (auto i = 1; i <= N; ++i)
	{
		if (cycle[i] != vertex[i])
		{
			is_cycle = true;
			break;
		}
	}

	for (auto i = 2; i <= N; ++i)
	{
		if (is_cycle)
		{
			cout << "-1" << "\n";
			break;
		}
		else if (vertex[i] == INF)
		{
			cout << "-1" << "\n";
		}
		else
		{
			cout << vertex[i] << "\n";
		}
	}

	return 0;
}