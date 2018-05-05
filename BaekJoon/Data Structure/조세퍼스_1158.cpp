#include <iostream>
#include <queue>

using namespace std;

int main(void)
{
	int n;
	int m;
	queue<int> q;

	cin >> n;
	cin >> m;

	for (auto i = 1; i <= n; ++i)
	{
		q.push(i);
	}

	cout << "<";

	while (!q.empty())
	{
		for (auto i = 0; i < m - 1; ++i)
		{
			q.push(q.front());
			q.pop();
		}

		if (q.size() != 1)
		{
			cout << q.front() << ", ";
			q.pop();
		}
		else
		{
			cout << q.front();
			q.pop();
		}
	}

	cout << ">" << endl;

	return 0;
}