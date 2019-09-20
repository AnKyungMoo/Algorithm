import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int q = Integer.parseInt(br.readLine());
			
			String[] s;
			int[] arr = new int[3];
			for (int t = 1; t <= q; ++t) {
				s = br.readLine().split(" ");
				
				int min = 1000000001;
				for (int i = 0; i < 3; ++i) {
					arr[i] = Integer.parseInt(s[i]);
					
					if (min > arr[i]) {
						min = arr[i];
					}
				}
				
				int result = 0;
				
				result += min;
				for (int i = 0; i < 3; ++i) {
					arr[i] -= min;
				}
				
				int small = Math.min(arr[0], arr[1]);
				int big = Math.max(arr[0], arr[1]);
				
				if (small * 2 <= big) {
					result += small;
				} else {
					result += (small + big) / 3;
				}
				
				System.out.println(result);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
