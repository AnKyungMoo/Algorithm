import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Node {
	int start;
	int end;
	double cost;
	
	Node(int start, int end, double cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

public class Solution_1251_하나로_안경무 {
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

			String[] s1;
			String[] s2;
			double[] xPoint;
			double[] yPoint;
			for (int t = 1; t <= T; ++t) {
				int N = Integer.parseInt(br.readLine());
				xPoint = new double[N];
				yPoint = new double[N];
				ArrayList<Node> arrayList = new ArrayList<>();
				parent = new int[N + 1];
				
				for (int i = 1; i <= N; ++i) {
					parent[i] = i;
				}
				
				s1 = br.readLine().split(" ");
				s2 = br.readLine().split(" ");
				
				double rate = Double.parseDouble(br.readLine());
				for (int i = 0; i < N; ++i) {
					xPoint[i] = Double.parseDouble(s1[i]);
					yPoint[i] = Double.parseDouble(s2[i]);
				}
				
				for (int i = 0; i < N; ++i) {
					for (int j = 0; j < N; ++j) {
						if (i == j) {
							continue;
						}
						
						double cost = (((xPoint[i] - xPoint[j]) * (xPoint[i] - xPoint[j])) + ((yPoint[i] - yPoint[j]) * (yPoint[i] - yPoint[j]))) * rate;
						
						arrayList.add(new Node(i, j, cost));
					}
				}
				
				Collections.sort(arrayList, (n1, n2) -> {
					if (n1.cost > n2.cost) {
						return 1;
					} else if (n1.cost == n2.cost){
						return 0;
					}
					return -1;
				});
				
				double result = 0;
				for (Node n : arrayList) {
					if (find(n.start) != find(n.end)) {
						result += n.cost;
						union(n.start, n.end);
					}
				}
				
				System.out.printf("#%d %.0f\n", t, result);
//				System.out.println("#" + t + " " + Math.round(result));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}