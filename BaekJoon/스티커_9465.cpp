#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	int d[100001][3];
	vector<vector<int>> score_table;
	int test_case;
	int n;
	int number;

	cin >> test_case;

	for (auto i = 0; i < test_case; ++i)
	{
		cin >> n;

		for (auto j = 0; j < 2; ++j)
		{
			vector<int> temp_table;
			for (auto k = 0; k < n; ++k)
			{
				cin >> number;
				temp_table.push_back(number);
			}
			score_table.push_back(temp_table);
		}

		d[0][0] = 0;
		d[0][1] = 0;
		d[0][2] = 0;

		for (auto j = 1; j <= n; ++j)
		{
			d[j][0] = max(max(d[j - 1][0], d[j - 1][1]), d[j - 1][2]);
			d[j][1] = max(d[j - 1][0], d[j - 1][2]) + score_table[0][j - 1];
			d[j][2] = max(d[j - 1][0], d[j - 1][1]) + score_table[1][j - 1];
		}

		cout << max(max(d[n][0], d[n][1]), d[n][2]) << endl;
		score_table.clear();
	}

	return 0;
}