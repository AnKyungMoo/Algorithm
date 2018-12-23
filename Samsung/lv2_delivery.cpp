#include <iostream>
#include <vector>
#define INF 9999

using namespace std;

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
				if (i == j)
				{
					country[i][j] = 0;
				}
				else
				{
					country[i][j] = INF;
				}
			}
		}

		// ����ؾ��� �� ����
		for (auto k = 0; k < K; ++k)
		{
			int node;

			cin >> node;

			delivery.push_back(node);
		}

		// ���� �Է�
		for (auto m = 0; m < M; ++m)
		{
			int a, b;
			cin >> a;
			cin >> b;

			country[a][b] = 1;
			country[b][a] = 1;
		}

		// �÷��̵� �˰���
		for (auto k = 1; k <= N; ++k)
		{
			for (auto i = 1; i <= N; ++i)
			{
				for (auto j = 1; j <= N; ++j)
				{
					if (country[i][j] > country[i][k] + country[k][j])
					{
						country[i][j] = country[i][k] + country[k][j];
					}
				}
			}
		}

		// �̵� ��� �����ؼ� �ջ�
		int prev = delivery[0];

		delivery.erase(delivery.begin());
		result += country[S][prev];
		
		for (auto k = 0; k < K-1; ++k)
		{
			result += country[prev][delivery.front()];
			prev = delivery.front();
			delivery.erase(delivery.begin());
		}

		result += country[prev][S];

		cout << "#" << t + 1 << " " << result << endl;
	}

	return 0;
}