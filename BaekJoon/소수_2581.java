import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	private boolean isPrime(int x) {
		if (x <= 1) {
			return false;
		}
		
		for (int i = 2; i <= Math.sqrt(x); ++i) {
			if (x % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int M = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			
			int sum = 0;
			int min = -1;
			for (int i = M; i <= N; ++i) {
				if (isPrime(i)) {
					sum += i;
					if (min == -1) {
						min = i;
					}
				}
			}
			
			if (sum != 0) {
				System.out.println(sum);
			}
			System.out.println(min);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main().solve();
	}
}