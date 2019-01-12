#include <iostream>
#include <vector>
#include <deque>

using namespace std;

struct Node
{
	int number;
	int push_index;
};

int main(void)
{
	ios::sync_with_stdio(false);
	int N, L;
	vector<int> v;

	cin >> N >> L;

	for (auto i = 0; i < N; ++i)
	{
		int insert;

		cin >> insert;

		v.push_back(insert);
	}

	deque<Node> dq;
	int time = 0;
	
	for (auto i = 0; i < N; ++i)
	{
		while (!dq.empty() && dq.back().number >= v[i])
		{
			dq.pop_back();
		}

		dq.push_back({ v[i], i });

		cout << dq.front().number << " ";
		time++;

		if (time - dq.front().push_index == L)
		{
			dq.pop_front();
			time = i + 1;
		}
	}

	return 0;
}