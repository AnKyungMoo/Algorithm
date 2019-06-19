#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main(void)
{
	long long x, y, z;

	cin >> x >> y >> z;

	long long remain_x = x % z;
	long long remain_y = y % z;

	long long result = (x / z) + (y / z);
	long long minimum = 0;

	if (remain_x != 0 && remain_y != 0)
	{
		if ((remain_x + remain_y) % z == 0)
		{
			result += (remain_x + remain_y) / z;
			minimum = min(remain_x, remain_y);
		}
		else
		{
			if (remain_x + remain_y >= z)
			{
				long long big = max(remain_x, remain_y);

				result++;
				minimum = z - big;
			}
		}
	}

	cout << result << " " << minimum << "\n";

	return 0;
}