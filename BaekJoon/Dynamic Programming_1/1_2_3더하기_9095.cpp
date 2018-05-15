#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	vector<int> memo;
	int t;
	int num;

	cin >> t;

	memo.push_back(0);
	memo.push_back(1);
	memo.push_back(2);
	memo.push_back(4);

	for (auto i = 0; i < t; ++i)
	{
		cin >> num;

		for (auto j = 4; j <= num; ++j)
		{
			memo.push_back(memo[j - 3] + memo[j - 2] + memo[j - 1]);
		}

		cout << memo[num] << endl;

		for (auto j = 4; j <= num; ++j)
		{
			memo.pop_back();
		}
	}

	return 0;
}