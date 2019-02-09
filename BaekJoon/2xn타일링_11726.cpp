#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	vector<int> memo;
	int n;
	
	cin >> n;

	memo.push_back(0);
	memo.push_back(1);
	memo.push_back(2);

	for (auto i = 3; i <= n; ++i)
	{
		memo.push_back(memo[i - 1] + memo[i - 2]);

		memo[i] = memo[i] % 10007;
	}

	cout << memo[n] << endl;

	return 0;
}