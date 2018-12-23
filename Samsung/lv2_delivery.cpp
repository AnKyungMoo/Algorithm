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
	 * N: ��� ������ ��
	 * M: �� ������ �����ϴ� ������ ��
	 * K: ���ư� ����� �ؾ��ϴ� ������ ��
	 * S: ���ư� ��� �Ƹ�����Ʈ�� �ϴ� ���԰� �ִ� ���� ��ȣ
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
		
		// �׷��� �ʱ�ȭ
		for (auto i = 0; i <= N; ++i)
		{
			for (auto j = 0; j <= N; ++j)
			{
				country[i][j] = 0;
			}
		}

		// ����ؾ��� �� ����
		for (auto k = 0; k < K; ++k)
		{
			int node;

			cin >> node;

			delivery.push_back(node);
		}
		delivery.push_back(S);

		// ���� �Է�
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
		 * ���������� ù ��° ��ǥġ�� ����
		 * ù ��° ��ǥġ���� �� ��° ��ǥġ�� ����
		 * �� ��° ��ǥġ���� �������� ����
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