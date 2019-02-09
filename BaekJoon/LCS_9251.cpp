#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int LCS[1001][1001];

int main(void)
{
	string s1, s2;

	cin >> s1;
	cin >> s2;

	for (auto i = 0; i < s1.length(); ++i)
	{
		for (auto j = 0; j < s2.length(); ++j)
		{
			if (s1[i] == s2[j])
			{
				LCS[i + 1][j + 1] = LCS[i][j] + 1;
			}
			else
			{
				LCS[i + 1][j + 1] = max(LCS[i+1][j], LCS[i][j + 1]);
			}
		}
	}

	printf("%d", LCS[s1.length()][s2.length()]);

	return 0;
}