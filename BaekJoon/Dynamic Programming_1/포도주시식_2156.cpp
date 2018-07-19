#include <iostream>
#include <algorithm>

using namespace std;

int main(void)
{
	int d[10001];
	int a[10001];
	int size;

	cin >> size;

	for (auto i = 1; i <= size; ++i)
	{
		cin >> a[i];
	}

	d[1] = a[1];

	d[2] = a[1] + a[2];

	for (auto i = 3; i <= size; ++i)
	{
		d[i] = max(max(d[i - 1], d[i - 2] + a[i]), d[i - 3] + a[i] + a[i - 1]);
	}

	cout << d[size] << endl;
	
	return 0;
}