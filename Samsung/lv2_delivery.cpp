#include <iostream>
#include <vector>
#define INF 9999

using namespace std;

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

		// 배달해야할 곳 저장
		for (auto k = 0; k < K; ++k)
		{
			int node;

			cin >> node;

			delivery.push_back(node);
		}

		// 간선 입력
		for (auto m = 0; m < M; ++m)
		{
			int a, b;
			cin >> a;
			cin >> b;

			country[a][b] = 1;
			country[b][a] = 1;
		}

		// 플로이드 알고리즘
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

		// 이동 경로 추적해서 합산
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