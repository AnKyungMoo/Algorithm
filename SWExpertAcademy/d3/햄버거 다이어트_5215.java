import java.io.*;

public class Solution {
	
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.parseInt(br.readLine());
			
			for (int t = 1; t <= T; ++t) {
				String[] s = br.readLine().split(" ");
				int N = Integer.parseInt(s[0]);
				int L = Integer.parseInt(s[1]);
				
				int[][] dp = new int[N + 1][L + 1];
				
				for (int n = 1; n <= N; ++n) {
					s = br.readLine().split(" ");
					int flavor = Integer.parseInt(s[0]);
					int kcal = Integer.parseInt(s[1]);
					
					for (int j = 0; j <= L; ++j) {
						if (j - kcal >= 0) {
							dp[n][j] = Math.max(dp[n-1][j - kcal] + flavor, dp[n-1][j]);
						} else {
							dp[n][j] = Math.max(dp[n][j], dp[n-1][j]);
						}
					}
				}
				
				System.out.println("#" + t + " " + dp[N][L]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}
