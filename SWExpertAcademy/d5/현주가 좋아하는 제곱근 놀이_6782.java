import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());
			
			for (int t = 1; t <= T; ++t) {
				long N = Long.parseLong(br.readLine());
				long result = 0;
				
				while (N > 2) {
					double temp = Math.sqrt(N);
					if (temp - Math.floor(temp) > 0) {
						long a = (long)(temp + 1);
						
						long compare = a * a;
						result += compare - N;
						N = compare;
					} else {
						N = (long)temp;
						result++;
					}
				}
				
				while (N < 2) {
					N++;
					result++;
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
