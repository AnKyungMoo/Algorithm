#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	vector<int> memo;
	int num;

	cin >> num;

	memo.push_back(0);
	memo.push_back(1);
	memo.push_back(3);

	for (auto i = 3; i <= num; ++i)
	{
		memo.push_back((2 * memo[i - 2]) + memo[i - 1]);

		memo[i] %= 10007;
	}
	
	cout << memo[num] << endl;

	return 0;
}