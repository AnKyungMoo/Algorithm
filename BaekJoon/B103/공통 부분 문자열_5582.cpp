#include <iostream>
#include <sstream>

using namespace std;

int D[4001][4001];

int main(void)
{
	string a, b;
	int result = 0;

	cin >> a;
	cin >> b;

	int a_length = a.length();
	int b_length = b.length();

	for (auto i = 1; i <= a_length; ++i)
	{
		for (auto j = 1; j <= b_length; ++j)
		{
			if (a[i - 1] == b[j - 1])
			{
				D[i][j] = D[i - 1][j - 1] + 1;

				if (result < D[i][j])
					result = D[i][j];
			}
		}
	}

	cout << result << "\n";

	return 0;
}