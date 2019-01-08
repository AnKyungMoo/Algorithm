#include <iostream>

using namespace std;

int main(void)
{
	int arr[100001];
	int N, M;
	int result = 0;

	cin >> N >> M;

	for (auto i = 1; i <= N; ++i)
	{
		cin >> arr[i];
	}

	for (auto i = 1; i <= N; ++i)
	{
		int curr = arr[i];
		for (auto j = i; j <= N; ++j)
		{
			if (i != j)
			{
				curr += arr[j];
			}

			if (curr == M)
			{
				result++;
				break;
			}
		}
	}

	cout << result << endl;

	return 0;
}