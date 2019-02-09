#include <iostream>

using namespace std;

int main(void)
{
	int n;
	long long result[91];

	cin >> n;

	result[1] = 1;
	result[2] = 1;

	for (auto i = 3; i <= n; ++i)
	{
		result[i] = result[i - 1] + result[i - 2];
	}

	cout << result[n] << endl;

	return 0;
}