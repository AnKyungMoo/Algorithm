import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Node {
	int start;
	int end;
	int cost;
	
	Node(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

public class Solution_3124_최소스패닝트리_안경무 {
	int[] parent;
	
	private int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	private void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) {
			parent[rootA] = rootB;
		}
	}
	
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());
			
			String[] s;
			Node[] arr;
			for (int t = 1; t <= T; ++t) {
				s = br.readLine().split(" ");
				int V = Integer.parseInt(s[0]);
				int E = Integer.parseInt(s[1]);
				arr = new Node[E];
				parent = new int[V + 1];
				
				for (int i = 1; i <= V; ++i) {
					parent[i] = i;
				}
				
				for (int i = 0; i < E; ++i) {
					s = br.readLine().split(" ");
					arr[i] = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
				}
				
				Arrays.sort(arr, (n1, n2) -> {
					if (n1.cost > n2.cost) {
						return 1;
					} else if (n1.cost == n2.cost) {
						return 0;
					}
					return -1;
				});
				
				long result = 0;
				for (int i = 0; i < E; ++i) {
					if (find(arr[i].start) != find(arr[i].end)) {
						result += arr[i].cost;
						union(arr[i].start, arr[i].end);
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