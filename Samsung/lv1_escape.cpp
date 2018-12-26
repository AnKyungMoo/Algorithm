#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	int T;

	vector<int> car;
	vector<int> color;
	vector<int> prisoner;

	/*
	 * N: 톨게이트를 통과한 차량의 수
	 * M: 존재할 수 있는 차량의 색상 수
	 */
	int N, M;

	cin >> T;

	for (auto t = 0; t < T; ++t)
	{
		int index = 0;

		cin >> N >> M;

		vector<int>().swap(prisoner);
		vector<int>().swap(car);
		vector<int>().swap(color);

		color.push_back(0);
		car.push_back(0);

		for (auto m = 1; m <= M; ++m)
		{
			int insert;

			cin >> insert;

			color.push_back(insert);

			for (auto c = 0; c < color[m]; ++c)
			{
				prisoner.push_back(m);
			}
		}

		for (auto n = 1; n <= N; ++n)
		{
			int insert;

			cin >> insert;

			car.push_back(insert);
		}

		auto prisoner_size = prisoner.size();

		for (auto i = 1; i <= N - prisoner_size + 1; ++i)
		{
			vector<int> result;

			for (auto j = 0; j < prisoner_size; ++j)
			{
				result.push_back(car[i + j]);
			}

			sort(result.begin(), result.end());

			if (result == prisoner)
			{
				index = i;
				break;
			}
		}

		if (N == prisoner_size)
		{
			vector<int> result;

			for (auto j = 1; j <= prisoner_size; ++j)
			{
				result.push_back(car[j]);
			}

			sort(result.begin(), result.end());

			if (prisoner == result)
			{
				index = 1;
			}
		}

		cout << "#" << t + 1 << " " << index << endl;
	}

	return 0;
}