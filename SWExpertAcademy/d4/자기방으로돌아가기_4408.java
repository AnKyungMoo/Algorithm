import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Node {
	int start;
	int end;
	
	Node(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Solution_4408_자기방으로돌아가기_안경무 {
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine().trim());
			
			String[] s;
			for (int t = 1; t <= T; ++t) {
				ArrayList<Node> arrayList = new ArrayList<>();
				int N = Integer.parseInt(br.readLine().trim());
				boolean[] visit = new boolean[N];
				
				for (int i = 0; i < N; ++i) {
					s = br.readLine().split(" ");
					
					int start = Integer.parseInt(s[0]);
					int end = Integer.parseInt(s[1]);
					
					if (end < start) {
						int temp = start;
						start = end;
						end = temp;
					}
					
					arrayList.add(new Node(start, end));
				}
				
				Collections.sort(arrayList, (n1, n2) -> {
					return n1.start > n2.start ? 1 : -1;
				});
				
				boolean flag = true;
				Node curr = arrayList.get(0);
				int result = 0;
				int currentIndex = 0;
				while (flag) {
					flag = false;
					visit[currentIndex] = true;
					if (curr == arrayList.get(N - 1)) {
						result++;
						break;
					}
					
					for (int i = 0; i < N; ++i) {
						if (visit[i] || (curr.end % 2 == 1 && curr.end + 1 == arrayList.get(i).start)) {
							continue;
						}
						if (!visit[i] && curr.end < arrayList.get(i).start) {
							visit[i] = true;
							curr = arrayList.get(i);
						}
					}
					
					for (int i = 0; i < N; ++i) {
						if (!visit[i]) {
							curr = arrayList.get(i);
							currentIndex = i;
							flag = true;
							break;
						}
					}
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