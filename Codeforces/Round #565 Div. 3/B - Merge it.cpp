#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main(void)
{
	int T;

	cin >> T;

	for (int t = 1; t <= T; ++t)
	{
		int N;

		cin >> N;

		int arr[4] = {0, };

		for (int i = 0; i < N; ++i)
		{
			int number;
			cin >> number;

			int index = number % 3;
			arr[index]++;
		}

		int result = arr[0];

		if (arr[2] >= arr[1])
		{
			result += arr[1];
			arr[2] -= arr[1];
			arr[1] = 0;

			result += arr[2] / 3;
		}
		else
		{
			result += arr[2];
			arr[1] -= arr[2];
			arr[2] = 0;

			result += arr[1] / 3;
		}

		cout << result << "\n";
	}

	return 0;
}