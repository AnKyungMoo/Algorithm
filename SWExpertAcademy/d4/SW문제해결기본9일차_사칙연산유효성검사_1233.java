import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class ArrayNode {
	String alpha;
	int left;
	int right;
	
	ArrayNode(String alpha) {
		this.alpha = alpha;
		left = -1;
		right = -1;
	}
	
	ArrayNode(String alpha, int left) {
		this.alpha = alpha;
		this.left = left;
		right = -1;
	}
	
	ArrayNode(String alpha, int left, int right) {
		this.alpha = alpha;
		this.left = left;
		this.right = right;
	}
}

public class Solution {
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			for (int t = 1; t <= 10; ++t) {
				int N = Integer.parseInt(br.readLine());
				
				ArrayNode[] arr = new ArrayNode[N + 1];
				String[] s;
				boolean flag = true;
				for (int i = 0; i < N; ++i) {
					s = br.readLine().split(" ");
					
					
					if (s.length == 2) {
						if (s[1].equals("+") || s[1].equals("-") || s[1].equals("*") || s[1].equals("/")) {
							flag = false;
						}
						
						arr[Integer.parseInt(s[0])] = new ArrayNode(s[1]);
					} else if (s.length == 3) {
						if (!(s[1].equals("+") || s[1].equals("-") || s[1].equals("*") || s[1].equals("/"))) {
							flag = false;
						}
						arr[Integer.parseInt(s[0])] = new ArrayNode(s[1], Integer.parseInt(s[2]));
					} else {
						if (!(s[1].equals("+") || s[1].equals("-") || s[1].equals("*") || s[1].equals("/"))) {
							flag = false;
						}
						arr[Integer.parseInt(s[0])] = new ArrayNode(s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]));						
					}
				}
				
				int result = 0;
				
				if (flag) {
					result = 1;
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