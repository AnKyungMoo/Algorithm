import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	int[][] arr;
	int blue;
	int white;

	private void division(int startY, int startX, int endY, int endX) {
		int curr = arr[startY][startX];

		boolean isDifference = false;
		for (int i = startY; i <= endY; ++i) {
			for (int j = startX; j <= endX; ++j) {
				if (curr != arr[i][j]) {
					isDifference = true;
					i = endY + 1;
					break;
				}
			}
		}

		if (isDifference) {
			division(startY, startX, (endY + startY) / 2, (endX + startX) / 2);
			division((endY + startY) / 2 + 1, startX, endY, (endX + startX) / 2);
			division(startY, (endX + startX) / 2 + 1, (endY + startY) / 2, endX);
			division((endY + startY) / 2 + 1, (endX + startX) / 2 + 1, endY, endX);
		} else {
			if (curr == 1) {
				blue++;
			} else {
				white++;
			}
		}
	}

	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			blue = 0;
			white = 0;

			String[] s;
			for (int i = 0; i < N; ++i) {
				s = br.readLine().split(" ");

				for (int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}

			division(0, 0, N - 1, N - 1);

			System.out.println(white);
			System.out.println(blue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main().solve();
	}
}