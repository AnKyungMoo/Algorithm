#include <iostream>
#include <vector>

using namespace std;

bool arr[4000001] = { false, };
vector<int> v;

int main(void)
{
	int N;
	int left = 0, right = 0;
	int result = 0;

	cin >> N;

	for (auto i = 2; i <= N; ++i)
	{
		if (!arr[i])
		{
			v.push_back(i);
			for (auto j = 2; j <= N / i; ++j)
			{
				if (!arr[i * j])
				{
					arr[i * j] = true;
				}
			}
		}
	}

	int sum = 0;
	int size = v.size();

	while (left < size)
	{
		sum = 0;

		for (auto i = left; i <= right; ++i)
		{
			sum += v[i];

			if (sum == N)
			{
				result++;
				left++;

				if (left > right)
				{
					right = left;
					break;
				}
			}
			else if (sum > N)
			{
				break;
			}
		}

		if (right == size - 1)
			left++;
		else
			right++;
	}

	cout << result;

	return 0;
}