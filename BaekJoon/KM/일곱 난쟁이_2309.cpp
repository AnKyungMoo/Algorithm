#include <iostream>
#include <algorithm>

using namespace std;

int main(void)
{
	int arr[10] = { 0, };
	int sum = 0;

	for (auto i = 1; i <= 9; ++i)
	{
		scanf("%d", &arr[i]);
		sum += arr[i];
	}

	for (auto i = 1; i <= 9; ++i)
	{
		for (auto j = i + 1; j <= 9; ++j)
		{
			if (sum - arr[i] - arr[j] == 100)
			{
				arr[i] = 101;
				arr[j] = 101;

				i = 10;
				break;
			}
		}
	}

	sort(arr+1, arr+10);

	for (auto i = 1; i <= 9; ++i)
	{
		if (arr[i] == 101)
			continue;

		printf("%d\n", arr[i]);
	}

	return 0;
}