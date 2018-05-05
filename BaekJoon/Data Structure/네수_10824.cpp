#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	string a, b, c, d;

	cin >> a;
	cin >> b;
	cin >> c;
	cin >> d;

	a += b;
	c += d;

	cout << stoll(a) + stoll(c) << endl;

	return 0;
}