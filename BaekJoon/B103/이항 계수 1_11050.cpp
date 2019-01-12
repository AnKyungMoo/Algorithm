#include <iostream>

int main(void)
{
	int N, K;
	int result = 1;

	scanf("%d %d", &N, &K);

	for (auto i = N; i > N - K; --i)
	{
		result *= i;
	}

	for (auto i = 1; i <= K; ++i)
	{
		result /= i;
	}

	printf("%d", result);

	return 0;
}