#include <iostream>
#include <algorithm>

using namespace std;

struct Node
{
	int number;
	int rate;
	int power;
};

Node arr[500001];
Node sorted_arr[500001];

bool compare(Node a, Node b)
{
	return a.number < b.number;
}

void merge_sort(int left, int right)
{
	int mid = (left + right) / 2 + 1;

	if (left == right)
		return;

	merge_sort(left, mid - 1);
	merge_sort(mid, right);

	int temp_left = left;
	int temp_mid = mid;
	auto count = left;

	while (temp_left < mid && temp_mid <= right)
	{
		if (arr[temp_left].power < arr[temp_mid].power)
		{
			arr[temp_mid].rate -= mid - temp_left;

			sorted_arr[count++] = arr[temp_mid++];
		}

		else
		{
			sorted_arr[count++] = arr[temp_left++];
		}
	}

	while (temp_left < mid)
	{
		sorted_arr[count++] = arr[temp_left++];
	}

	while (temp_mid <= right)
	{
		sorted_arr[count++] = arr[temp_mid++];
	}

	for (auto i = left; i <= right; ++i)
	{
		arr[i] = sorted_arr[i];
	}
}

int main(void)
{
	int N;

	cin >> N;

	for (auto i = 1; i <= N; ++i)
	{
		arr[i].rate = arr[i].number = i;
		cin >> arr[i].power;
	}

	merge_sort(1, N);

	sort(arr + 1, arr + N + 1, compare);

	for (auto i = 1; i <= N; ++i)
	{
		cout << arr[i].rate << " ";
	}

	return 0;
}