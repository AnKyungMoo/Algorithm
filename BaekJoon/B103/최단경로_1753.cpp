#include <iostream>
#include <vector>
#include <queue>
#define INF 200000

using namespace std;

struct Node
{
	int number;
	int cost;
};

struct compare
{
	bool operator()(Node a, Node b)
	{
		return a.cost > b.cost;
	}
};

vector<Node> graph[20001];
int vertex[20001] = { 0, };

int main(void)
{
	ios::sync_with_stdio(false);
	int V, E, K;
	int u, v, w;
	priority_queue<Node, vector<Node>, compare> pq;

	cin >> V >> E;

	cin >> K;

	for (auto i = 0; i < E; ++i)
	{
		cin >> u >> v >> w;

		graph[u].push_back({ v, w });
	}

	for (auto i = 1; i <= V; ++i)
	{
		vertex[i] = INF;
	}

	vertex[K] = 0;

	pq.push({ K, 0 });

	while (!pq.empty())
	{
		auto n = pq.top();
		pq.pop();

		for (auto g : graph[n.number])
		{
			if (vertex[g.number] > vertex[n.number] + g.cost)
			{
				vertex[g.number] = vertex[n.number] + g.cost;
				pq.push({ g.number, vertex[g.number] });
			}
		}
	}

	for (auto i = 1; i <= V; ++i)
	{
		if (vertex[i] == INF)
			cout << "INF\n";
		else
			cout << vertex[i] << "\n";
	}

	return 0;
}