#include <iostream>

using namespace std;

int board[50][50];

int direct[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
int back[4][2] = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };

int main(void)
{
	int N, M;

	cin >> N >> M;

	int r, c, d;

	cin >> r >> c >> d;

	for (int i = 0; i < N; ++i)
	{
		for (int j = 0; j < M; ++j)
		{
			cin >> board[i][j];
		}
	}

	int result = 0;

	if (board[r][c] == 0)
	{
		board[r][c] = 2;
		result++;
	}

	int count = 0;
	while (true)
	{
		int temp_d = d - 1;
		if (temp_d == -1)
		{
			temp_d = 3;
		}

		int new_r = r + direct[temp_d][0];
		int new_c = c + direct[temp_d][1];

		if (new_r >= 0 && new_r < N && new_c >= 0 && new_c < M)
		{
			if (board[new_r][new_c] == 0)
			{
				d = temp_d;
				r = new_r;
				c = new_c;
				board[r][c] = 2;
				count = 0;
				result++;
			}
			else
			{
				if (count == 4)
				{
					int back_r = r + back[d][0];
					int back_c = c + back[d][1];

					if (back_r < 0 || back_r >= N || back_c < 0 || back_c >= M)
					{
						break;
					}

					if (board[back_r][back_c] == 1)
					{
						break;
					}
					else
					{
						r = back_r;
						c = back_c;
						count = 0;
					}
				}
				else
				{
					d = temp_d;
					count++;
				}
			}
		}
	}

	cout << result;

	return 0;
}