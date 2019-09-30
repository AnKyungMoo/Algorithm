import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());
			
			String[] s;
			for (int t = 1; t <= T; ++t) {
				s = br.readLine().split(" ");
				int N = Integer.parseInt(s[0]);
				int M = Integer.parseInt(s[1]);
				int[] arr = new int[N];
				
				for (int i = 0; i < N; ++i) {
					arr[i] = Integer.parseInt(br.readLine());
				}
				
				Arrays.sort(arr);
				
				long left = 0;
				long right = (long)arr[N - 1] * M;
				long result = (long)arr[N - 1] * M;
				while (left <= right) {
					long mid = (left + right) / 2;
					
					long human = 0;
					for (int i = 0; i < N; ++i) {
						human += mid / arr[i];
					}
					
					if (human >= M) {
						result = mid;
						right = mid - 1;
					} else {
						left = mid + 1;
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