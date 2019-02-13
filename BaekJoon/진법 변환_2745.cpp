#include <iostream>
#include <string>
#include <math.h>

using namespace std;

int main(void)
{
	string N;
	int B;
	int index = 0;

	cin >> N >> B;

	int size = N.length();
	int result = 0;

	for (auto i = size - 1; i >= 0; --i)
	{
		double temp = pow((double)B, (double)index++);
		
		if (N[i] >= 'A')
		{
			result += (N[i] - 'A' + 10) * (int)temp;
		}
		else
		{
			result += (N[i] - '0') * (int)temp;
		}
	}

	printf("%d\n", result);

	return 0;
}