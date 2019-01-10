#include <iostream>

using namespace std;

bool arr[1001][1001] = { false, };
int results[1001] = { 0, };

int gcd(int x, int y)
{
	if (y == 0)
		return x;
	return gcd(y, x % y);
}

int main(void)
{
	int C, N;
	int row, col;

	scanf("%d", &C);

	fill_n(&arr[0][0], 1001 * 1001, false);

	for (auto i = 1; i <= 1000; ++i)
	{
		for (auto j = 1; j <= i; ++j)
		{
			auto g = gcd(i, j);

			col = i / g;
			row = j / g;

			if (!arr[col][row])
			{
				arr[col][row] = true;
				results[i]++;
			}
		}

		results[i] += results[i - 1];
	}

	for (auto c = 0; c < C; ++c)
	{
		scanf("%d", &N);

		printf("%d\n", results[N] * 2 + 1);
	}

	return 0;
}