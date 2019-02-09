#include <iostream>

using namespace std;

int gcd(int a, int b)
{
	if (b == 0)
		return a;

	return gcd(b, a % b);
}

int main(void)
{
	int t;
	int n;
	int nums[101] = { 0, };
	int left, right;
	long long sum = 0;

	scanf("%d", &t);

	for (auto test_case = 0; test_case < t; ++test_case)
	{
		scanf("%d", &n);

		for (auto i = 1; i <= n; ++i)
		{
			scanf("%d", &nums[i]);
		}

		left = 1;
		right = 2;
		sum = 0;

		while (left < n)
		{
			sum += gcd(nums[left], nums[right]);

			if (right == n)
			{
				left++;
				right = left + 1;
			}
			else
			{
				right++;
			}
		}

		printf("%lld\n", sum);
	}

	return 0;
}