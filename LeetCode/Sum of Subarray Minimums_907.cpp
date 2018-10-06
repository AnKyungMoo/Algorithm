#include <iostream>
#include <vector>
#include <sstream>
#include <algorithm>
#include <stack>

using namespace std;

class Solution {
public:
	int sumSubarrayMins(vector<int>& A) 
	{
		stack<int> st;
		int sum = 0;
		vector<int> d;

		for (auto i = 0; i < A.size(); ++i)
		{
			while (!st.empty() && A[i] < A[st.top()])
			{
				st.pop();
			}

			if (st.empty())
			{
				d.push_back((i + 1) * A[i]);
			}
			else
			{
				auto stack_value = st.top();

				d.push_back(d[stack_value] + ((i - stack_value) * A[i]));
			}

			cout << static_cast<int>(1e9) + 7 << endl;

			sum = (sum + d[i]) % 1000000007;
			st.push(i);
		}
		
		return sum;
	}
};

void trimLeftTrailingSpaces(string &input) {
	input.erase(input.begin(), find_if(input.begin(), input.end(), [](int ch) {
		return !isspace(ch);
	}));
}

void trimRightTrailingSpaces(string &input) {
	input.erase(find_if(input.rbegin(), input.rend(), [](int ch) {
		return !isspace(ch);
	}).base(), input.end());
}

vector<int> stringToIntegerVector(string input) {
	vector<int> output;
	trimLeftTrailingSpaces(input);
	trimRightTrailingSpaces(input);
	input = input.substr(1, input.length() - 2);
	stringstream ss;
	ss.str(input);
	string item;
	char delim = ',';
	while (getline(ss, item, delim)) {
		output.push_back(stoi(item));
	}
	return output;
}

int main() {
	string line;
	while (getline(cin, line)) {
		vector<int> A = stringToIntegerVector(line);

		int ret = Solution().sumSubarrayMins(A);

		string out = to_string(ret);
		cout << out << endl;
	}
	return 0;
}