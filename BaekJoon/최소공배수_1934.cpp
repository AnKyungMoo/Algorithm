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
	int T;
	int a, b;

	scanf("%d", &T);

	for (auto t = 0; t < T; ++t)
	{
		scanf("%d %d", &a, &b);

		int x = gcd(a, b);

		printf("%d\n", x * a / x * b / x);
	}

	return 0;
}