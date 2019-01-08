#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> graph[32001];
int indegree[32001] = { 0, };

int main(void)
{
	int N, M;
	int from, to;
	queue<int> search_queue;
	queue<int> closed_queue;

	cin >> N >> M;

	for (auto i = 1; i <= M; ++i)
	{
		cin >> from >> to;

		graph[from].push_back(to);

		indegree[to]++;
	}

	for (auto i = 1; i <= N; ++i)
	{
		if (indegree[i] == 0)
			search_queue.push(i);
	}

	while (!search_queue.empty())
	{
		auto node = search_queue.front();
		search_queue.pop();

		for (auto index : graph[node])
		{
			indegree[index]--;

			if (indegree[index] == 0)
				search_queue.push(index);
		}

		closed_queue.push(node);
	}

	while (!closed_queue.empty())
	{
		auto node = closed_queue.front();
		closed_queue.pop();

		cout << node << " ";
	}

	return 0;
}