#include <iostream>

using namespace std;

int gcd(int a, int b)
{
	if (b == 0)
		return a;

	return gcd(b, a % b);
}

int lcm(int a, int b)
{
	auto gcd_ = gcd(a, b);

	return gcd_ * a / gcd_ * b / gcd_;
}

int main(void)
{
	int a, b;

	scanf("%d %d", &a, &b);

	printf("%d\n", gcd(a, b));
	printf("%d\n", lcm(a, b));

	return 0;
}