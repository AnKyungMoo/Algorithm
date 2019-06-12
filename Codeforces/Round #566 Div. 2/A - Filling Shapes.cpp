#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main(void)
{
	int n;

	cin >> n;

	int result = 1;

	if (n % 2 == 0)
	{
		for (int i = 1; i <= n / 2; ++i)
		{
			result *= 2;
		}
	}
	else
	{
		result = 0;
	}

	cout << result << "\n";

	return 0;
}