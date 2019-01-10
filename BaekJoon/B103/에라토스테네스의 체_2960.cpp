#include <iostream>

using namespace std;

int main(void)
{
	bool arr[1001] = { false, };
	int N, K;

	cin >> N >> K;

	for (auto i = 2; i <= N; ++i)
	{
		if (!arr[i])
		{
			K--;
			if (K == 0)
			{
				cout << i << '\n';
				break;
			}

			for (auto j = 2; j <= N / i; ++j)
			{
				if (!arr[i * j])
				{
					arr[i * j] = true;
					K--;

					if (K == 0)
					{
						cout << i * j << '\n';
						i = N + 1;
						break;
					}
				}
			}
		}
	}

	return 0;
}