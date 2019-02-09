#include <iostream>
#include <string>
#include <stack>

using namespace std;

int  main(void)
{
	stack<int> st;
	string insert_string;
	int stick_count = 0;

	cin >> insert_string;

	for (auto i = 0; i < insert_string.size(); ++i)
	{
		if (insert_string[i] == '(')
		{
			st.push(i);
		}
		else if (insert_string[i] == ')')
		{
			if (st.top() == i - 1)
			{
				st.pop();
				stick_count += st.size();
			}
			else
			{
				st.pop();
				stick_count++;
			}
		}
	}

	cout << stick_count << endl;

	return 0;
}