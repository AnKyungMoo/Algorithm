import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2636 {
	class Node {
		int y;
		int x;
		
		Node (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] s = br.readLine().split(" ");
			
			int sero = Integer.parseInt(s[0]);
			int garo = Integer.parseInt(s[1]);
			int[][] arr = new int[sero][garo];
			boolean[][] visit = new boolean[sero][garo];
			int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
			
			for (int i = 0; i < sero; ++i) {
				s = br.readLine().split(" ");
				
				for (int j = 0; j < garo; ++j) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			Queue<Node> searchQueue = new LinkedList<>();
			Queue<Node> resultQueue = new LinkedList<>();
			int time = 0;
			int remainCount = 0;
			
			boolean flag = true;
			while (flag) {
				flag = false;
				searchQueue.add(new Node(0, 0));
				for (int i = 0; i < sero; ++i) {
					Arrays.fill(visit[i], false);
				}
				
				while (!searchQueue.isEmpty()) {
					Node n = searchQueue.poll();
					
					for (int i = 0; i < 4; ++i) {
						int newY = n.y + direct[i][0];
						int newX = n.x + direct[i][1];
						
						if (newY >= sero || newY < 0 || newX >= garo || newX < 0) {
							continue;
						}
						
						if (visit[newY][newX]) {
							continue;
						}
						
						visit[newY][newX] = true;
						if (arr[newY][newX] == 1) {
							resultQueue.add(new Node(newY, newX));
							flag = true;
						} else {
							searchQueue.add(new Node(newY, newX));
						}
					}
				}
				
				int tempCount = 0;
				while (!resultQueue.isEmpty()) {
					Node n = resultQueue.poll();
					
					arr[n.y][n.x] = 0;
					tempCount++;
				}
				
				if (flag) {
					remainCount = tempCount;
					time++;
				}
			}
			
			System.out.println(time);
			System.out.println(remainCount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main_2636().solve();
	}
}