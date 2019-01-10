#include <iostream>

using namespace std;

int gcd(int x, int y)
{
	if (y == 0)
		return x;
	return gcd(y, x % y);
}

int main(void)
{
	ios::sync_with_stdio(false);

	int a, b, c, d;

	cin >> a >> b;
	cin >> c >> d;

	auto mo = b * d;
	auto ja = a * d + c * b;

	auto g = gcd(ja, mo);

	cout << ja / g << " " << mo / g;

	return 0;
}