import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			char[][] arr = new char[n][n];
			
			boolean isBlack = false;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (isBlack) {
						System.out.print('W');
					} else {
						System.out.print('B');
					}
					
					isBlack = !isBlack;
				}
				if (n % 2 == 0) {
					isBlack = !isBlack;
				}
				System.out.println();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
