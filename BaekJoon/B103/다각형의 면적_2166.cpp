#include <iostream>

using namespace std;

typedef long long int lld;

struct Point
{
	lld x;
	lld y;

	Point operator - (const Point &A)
	{
		return{ x - A.x, y - A.y };
	}
};

lld ccw(Point A, Point B)
{
	return A.x * B.y - B.x * A.y;
}

lld ccw(Point A, Point B, Point C)
{
	return ccw(B - A, C - A);
}

int main(void)
{
	int n;
	Point p[10001];

	cin >> n;

	for (auto i = 1; i <= n; ++i)
	{
		cin >> p[i].x >> p[i].y;
	}

	lld result = 0;

	for (auto i = 1; i <= n - 1; ++i)
	{
		result += ccw({ 0, 0 }, p[i], p[i + 1]);
	}

	result += ccw({ 0, 0 }, p[n], p[1]);

	result = (lld)abs(result);

	printf("%.1lf", result / 2.0);

	return 0;
}