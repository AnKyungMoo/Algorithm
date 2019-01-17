#include <iostream>

using namespace std;

struct Node
{
	int x;
	int y;

	Node operator - (const Node &A)
	{
		return{ x - A.x, y - A.y };
	}
};

int ccw(Node A, Node B)
{
	long long int t = A.x * B.y - B.x * A.y;

	return t < 0 ? -1 : t > 0 ? 1 : 0;
}

int ccw(Node A, Node B, Node C)
{
	return ccw(B - A, C - A);
}

int main(void)
{
	Node n[3];

	for (auto i = 0; i < 3; ++i)
	{
		cin >> n[i].x >> n[i].y;
	}

	cout << ccw(n[0], n[1], n[2]) << "\n";

	return 0;
}