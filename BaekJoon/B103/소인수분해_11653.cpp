#include <iostream>
#include <vector>

using namespace std;

bool arr[10000001] = { false, };
vector<int> v;

int main(void)
{
	int N;

	cin >> N;

	for (auto i = 2; i <= N; ++i)
	{
		if (!arr[i])
		{
			v.push_back(i);
			for (auto j = 2; j <= N / i; ++j)
			{
				if (!arr[i * j])
				{
					arr[i * j] = true;
				}
			}
		}
	}

	int size = v.size();

	int curr = N;

	while (curr != 1)
	{
		for (auto i = 0; i < size; ++i)
		{
			if (curr % v[i] == 0)
			{
				curr /= v[i];
				cout << v[i] << "\n";
				break;
			}
		}
	}

	return 0;
}