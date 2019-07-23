import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());
			
			for (int t = 1; t <= T; ++t) {
				long N = Long.parseLong(br.readLine());
				
				int result = 0;
				while (true) {
					if (N % 2 == 1) {
						if ((N / 2) % 2 == 1) {
							result = 1;
							break;
						} else {
							break;
						}
					} else {
						N /= 2;
					}
				}
				
				System.out.println("#" + t + " " + result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}