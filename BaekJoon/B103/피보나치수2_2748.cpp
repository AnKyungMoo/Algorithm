#include <iostream>

using namespace std;

int main(void)
{
	long long fibo[91];
	int n;

	cin >> n;

	fibo[0] = 0;
	fibo[1] = 1;

	for (auto i = 2; i <= n; ++i)
	{
		fibo[i] = fibo[i - 1] + fibo[i - 2];
	}

	cout << fibo[n] << endl;

	return 0;
}