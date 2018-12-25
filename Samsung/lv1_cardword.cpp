#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>

using namespace std;

int main(void)
{
	int T;

	int N;
	vector<char> inputs;

	cin >> T;

	for (auto t = 0; t < T; ++t)
	{
		cin >> N;
		string result = "";

		vector<char>().swap(inputs);

		for (auto n = 0; n < N; ++n)
		{
			char ch;

			cin >> ch;

			inputs.push_back(ch);
		}

		result += inputs[0];

		auto inputs_size = inputs.size();
		for (auto i = 1; i < inputs_size; ++i)
		{
			if (inputs[i] >= *result.begin())
			{
				result = inputs[i] + result;
			}
			else
			{
				result += inputs[i];
			}
		}

		cout << "#" << t + 1 << " " << result << endl;
	}

	return 0;
}