#include <iostream>
#include <vector>

using namespace std;

struct Data
{
	int damage, count;
};
struct Combination
{
	int index1, index2;
};

int min(int num1, int num2)
{
	if (num1 < num2)
		return num1;
	return num2;
}

vector<struct Combination> combination[40001];

int main(void)
{
	/*
	*   T: 테스트케이스
	*   N: 외계 우주선의 총 수
	*   M: 미사일의 종류의 수
	*   B: 외계 우주선의 방어막 세기
	*/
	int T, N, M, B;

	struct Data data[1002];

	cin >> T;

	for (auto t = 0; t < T; ++t)
	{
		cin >> N;
		cin >> M;
		cin >> B;

		data[0].damage = 0;
		data[0].count = 2147483647;

		// 미사일 입력
		for (auto i = 1; i <= M; ++i)
		{
			cin >> data[i].damage;
			cin >> data[i].count;
		}

		// 조합 초기화
		for (auto i = 0; i <= 40000; ++i)
		{
			vector<struct Combination>().swap(combination[i]);
		}

		// 모든 조합을 구함
		for (auto i = 0; i <= M; ++i)
		{
			for (auto j = i; j <= M; ++j)
			{
				if (i == 0 && j == 0)
					continue;
				if (data[i].damage + data[j].damage >= B)
				{
					combination[data[i].damage + data[j].damage].push_back({ i, j });
				}
			}
		}

		// 조합 별로 우주선을 격추
		auto damage_sum = 0;
		for (auto i = B; i <= 40000; ++i)
		{
			auto n = (int)combination[i].size();
			for (auto j = 0; j < n; ++j)
			{
				auto value = min(data[combination[i][j].index1].count, data[combination[i][j].index2].count);
				if (combination[i][j].index1 == combination[i][j].index2)
					value /= 2;
				value = min(value, N);

				data[combination[i][j].index1].count -= value;
				data[combination[i][j].index2].count -= value;
				N -= value;
				damage_sum += data[combination[i][j].index1].damage * value;
				damage_sum += data[combination[i][j].index2].damage * value;

				if (N <= 0)
				{
					i = 40000;
					break;
				}
			}
		}

		if (N > 0)
			damage_sum = -1;

		cout << "#" << t + 1 << " " << damage_sum << endl;
	}

	return 0;
}