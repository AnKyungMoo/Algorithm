#include <iostream>

using namespace std;

int arr[1000001];

int main(void)
{
	int N, M;
	int max = 1000000000;
	int min = 0;
	int height;
	int result = 0;

	cin >> N >> M;

	for (auto i = 1; i <= N; ++i)
	{
		cin >> arr[i];
	}

	while (min <= max)
	{
		long long curr = 0;
		height = (min + max) / 2;

		for (auto i = 1; i <= N; ++i)
		{
			if (arr[i] - height >= 0)
				curr += arr[i] - height;
		}

		if (curr >= M)
		{
			min = height + 1;
			result = height;
		}
		else
			max = height - 1;
	}

	cout << result << endl;

	return 0;
}