import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int q = Integer.parseInt(br.readLine());
			
			int[] arr;
			String[] s;
			for (int tc = 1; tc <= q; ++tc) {
				int n = Integer.parseInt(br.readLine());
				arr = new int[2049];
				
				s = br.readLine().split(" ");
				for (int i = 0; i < n; ++i) {
					if (Integer.parseInt(s[i]) > 2048) {
						continue;
					}
					
					arr[Integer.parseInt(s[i])]++;
				}
				
				int index = 1;
				while (index < 2048) {
					arr[index * 2] += arr[index] / 2;
					
					index *= 2;
				}
				
				if (arr[2048] > 0) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
