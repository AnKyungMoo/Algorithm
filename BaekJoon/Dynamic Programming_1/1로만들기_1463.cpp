#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	vector<int> memo;
	int num;

	cin >> num;

	memo.resize(num + 1);

	memo[1] = 0;

	for (auto i = 2; i < memo.size(); ++i)
	{
		memo[i] = memo[i - 1] + 1;

		if (i % 2 == 0 && memo[i] > memo[i / 2] + 1)
		{
			memo[i] = memo[i / 2] + 1;
		}
		if (i % 3 == 0 && memo[i] > memo[i / 3] + 1)
		{
			memo[i] = memo[i / 3] + 1;
		}
	}

	cout << memo[num] << endl;

	return 0;
}