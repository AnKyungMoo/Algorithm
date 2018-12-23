#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Village
{
	int number;
	int weight;
};

int country[1001][1001];

int main(void)
{
	int T;
	/*
	 * N: 모든 마을의 수
	 * M: 두 마을을 연결하는 도로의 수
	 * K: 연아가 배달을 해야하는 마을의 수
	 * S: 연아가 배달 아르바이트를 하는 가게가 있는 마을 번호
	 */
	int N, M, K, S;

	cin >> T;

	for (auto t = 0; t < T; ++t)
	{
		vector<int> delivery;
		queue<Village> q;
		int result = 0;

		cin >> N;
		cin >> M;
		cin >> K;
		cin >> S;
		
		// 그래프 초기화
		for (auto i = 0; i <= N; ++i)
		{
			for (auto j = 0; j <= N; ++j)
			{
				country[i][j] = 0;
			}
		}

		// 배달해야할 곳 저장
		for (auto k = 0; k < K; ++k)
		{
			int node;

			cin >> node;

			delivery.push_back(node);
		}
		delivery.push_back(S);

		// 간선 입력
		for (auto m = 0; m < M; ++m)
		{
			int a, b;
			cin >> a;
			cin >> b;

			country[a][b] = 1;
			country[b][a] = 1;
		}

		q.push({ S, 0 });

		/*
		 * 시작점에서 첫 번째 목표치에 도달
		 * 첫 번째 목표치에서 두 번째 목표치에 도달
		 * 두 번째 목표치에서 시작점에 도달
		*/

		while (!delivery.empty())
		{
			bool visit[1000] = { false, };
			auto goal = delivery.front();
			delivery.erase(delivery.begin());

			// bfs
			while (!q.empty())
			{
				auto node = q.front();
				q.pop();
				visit[node.number] = true;

				if (node.number == goal)
				{
					result += node.weight;
					queue<Village>().swap(q);
					q.push({ node.number, 0 });
					break;
				}

				for (auto i = 1; i <= N; ++i)
				{
					if (visit[i])
					{
						continue;
					}

					if (country[node.number][i] == 1)
					{
						if (i == goal)
						{
							queue<Village>().swap(q);
							q.push({ i, node.weight + 1 });
							break;
						}
						q.push({ i, node.weight + 1 });
						visit[i] = true;
					}
				}
			}
		}

		cout << "#" << t + 1 << " " << result << endl;
	}

	return 0;
}