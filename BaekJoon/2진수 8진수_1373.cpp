#include <iostream>
#include <string>
#include <stack>
#include <math.h>

using namespace std;

int main(void)
{
	string N;
	stack<int> st;
	int index = 0;

	cin >> N;

	int size = N.length();

	for (auto i = size - 1; i >= 0; i -= 3)
	{
		int temp = 0;
		index = 0;
		for (auto j = i; j > i - 3 && j >= 0; --j)
		{
			temp += (N[j] - '0') * pow(2.0, (double)index++);
		}

		st.push(temp);
	}

	while (!st.empty())
	{
		printf("%d", st.top());
		st.pop();
	}

	return 0;
}