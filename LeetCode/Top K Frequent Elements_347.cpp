#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <sstream>

using namespace std;

class Solution {
public:
	vector<int> topKFrequent(vector<int>& nums, int k) 
	{
		map<int, int> m;
		vector<vector<int>> bucket;
		vector<int> result;

		bucket.resize(nums.size() + 1);

		const auto nums_size = nums.size();
		for (auto i = 0; i < nums_size; ++i)
		{
			++m[nums[i]];
		}		

		for (auto m_iter = m.begin(); m_iter != m.end(); ++m_iter)
		{
			bucket[m_iter->second].push_back(m_iter->first);
		}

		for (auto i = nums_size; i > 0 && k > 0; --i)
		{
			if (bucket[i].size() > 0)
			{
				for (auto bucket_iter = bucket[i].begin(); bucket_iter != bucket[i].end(); ++bucket_iter) {
					result.push_back(*bucket_iter);
					--k;
				}
			}
		}

		return result;
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

int stringToInteger(string input) {
	return stoi(input);
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
		vector<int> nums = stringToIntegerVector(line);
		getline(cin, line);
		int k = stringToInteger(line);

		vector<int> ret = Solution().topKFrequent(nums, k);

		string out = integerVectorToString(ret);
		cout << out << endl;
	}
	return 0;
}