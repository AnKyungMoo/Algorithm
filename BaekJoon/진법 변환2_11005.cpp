#include <iostream>
#include <stack>

using namespace std;

int main(void)
{
	int N, B;
	stack<char> st;

	scanf("%d %d", &N, &B);

	while (N != 0)
	{
		int value = N % B;
		N /= B;

		if (value >= 10)
			st.push('A' + value - 10);
		else
			st.push('0' + value);
	}

	while (!st.empty())
	{
		printf("%c", st.top());

		st.pop();
	}

	return 0;
}