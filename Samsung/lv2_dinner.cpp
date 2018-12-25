#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Node
{
	int index;
	int x;
	int y;
};

bool compare(struct Node node1, struct Node node2)
{
	if (node1.x != node2.x)
		return node1.x < node2.x;
	
	return node1.y < node2.y;
}

int main(void)
{
	int T;

	// N: 점의 개수
	int N;
	vector<struct Node> node;
	vector<struct Node> result;

	cin >> T;

	for (auto t = 0; t < T; ++t)
	{
		cin >> N;

		vector<struct Node>().swap(node);
		vector<struct Node>().swap(result);

		for (auto n = 1; n <= N; ++n)
		{
			int x, y;

			cin >> x >> y;

			node.push_back({ n, x, y });
		}

		sort(node.begin(), node.end(), compare);

		auto curr = node[0];

		for (auto i = 1; i < N; ++i)
		{
			if (curr.y > node[i].y)
			{
				result.push_back(curr);
				curr = node[i];
			}
		}

		result.push_back(curr);

		auto result_size = (int)result.size();

		cout << "#" << t + 1 << " ";
		for (auto i = 0; i < result_size; ++i)
		{
			cout << result[i].index << " ";
		}
		cout << endl;
	}
	return 0;
}