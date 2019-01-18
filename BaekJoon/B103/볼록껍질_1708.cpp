#include <iostream>
#include <algorithm>

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

	bool operator <(const Point &A)
	{
		return x == A.x ? y < A.y : x < A.x;
	}
};

lld ccw(Point A, Point B)
{
	return A.x * B.y - B.x * A.y;
}

lld ccw(Point A, Point B, Point C)
{
	lld t = ccw(B - A, C - A);
	return t < 0 ? -1 : t > 0;
}

Point up_chain[100001], down_chain[100001], convex[100001];
Point p[100001];

int main(void)
{
	int n;
	int up_top = 0, down_top = 0, convex_top = 0;

	scanf("%d", &n);

	for (auto i = 1; i <= n; ++i)
	{
		scanf("%lld %lld", &p[i].x, &p[i].y);
	}

	sort(p + 1, p + n + 1);

	for (auto i = 1; i <= n; ++i)
	{
		while (up_top > 1 && ccw(up_chain[up_top - 1], up_chain[up_top], p[i]) >= 0)
		{
			up_top--;
		}

		up_chain[++up_top] = p[i];
	}

	for (auto i = n; i >= 1; --i)
	{
		while (down_top > 1 && ccw(down_chain[down_top - 1], down_chain[down_top], p[i]) >= 0)
		{
			down_top--;
		}
		down_chain[++down_top] = p[i];
	}

	for (auto i = 1; i <= up_top; ++i)
	{
		convex[++convex_top] = up_chain[i];
	}

	for (auto i = 2; i < down_top; ++i)
	{
		convex[++convex_top] = down_chain[i];
	}

	printf("%d\n", convex_top);

	return 0;
}