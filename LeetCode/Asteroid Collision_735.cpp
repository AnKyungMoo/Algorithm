#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

class Solution {
public:
	vector<int> asteroidCollision(vector<int>& asteroids) {
		vector<int> v;

		for (auto i = 0; i < asteroids.size(); ++i)
		{
			if (v.empty())
			{
				v.push_back(asteroids[i]);
				continue;
			}

			if (v.back() * asteroids[i] > 0)
			{
				v.push_back(asteroids[i]);
			}
			else if (v.back() * asteroids[i] < 0)
			{
				if (v.back() < 0)
				{
					v.push_back(asteroids[i]);
				}
				else if (v.back() > 0)
				{
					const auto absolute_asteroids = asteroids[i] * -1;

					if (v.back() > absolute_asteroids)
					{
						continue;
					}
					else if (v.back() == absolute_asteroids)
					{
						v.pop_back();
						continue;
					}
					else
					{
						v.pop_back();

						if (v.size() != 0)
						{
							i -= 1;
							continue;
						}

						v.push_back(asteroids[i]);
					}
				}
			}
		}

		return v;
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

string integerVectorToString(vector<int> list, int length = -1) {
	if (length == -1) {
		length = list.size();
	}

	if (length == 0) {
		return "[]";
	}

	string result;
	for (int index = 0; index < length; index++) {
		int number = list[index];
		result += to_string(number) + ", ";
	}
	return "[" + result.substr(0, result.length() - 2) + "]";
}

int main() {
	string line;
	while (getline(cin, line)) {
		vector<int> asteroids = stringToIntegerVector(line);

		vector<int> ret = Solution().asteroidCollision(asteroids);

		string out = integerVectorToString(ret);
		cout << out << endl;
	}
	return 0;
}