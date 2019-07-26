import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int y;
	int x;
	
	Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Solution {
	int N, M;
	int[][] arr;
    int[][] virus;
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int result = 0;
    
	private void dfs(int y, int x, int wallCount) {
		if (wallCount >= 3) {
			/* 바이러스 탐색 */
			for (int i = 0; i < N; ++i) {
				virus[i] = arr[i].clone();
			}
			
			Queue<Node> queue = new LinkedList<>();
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (virus[i][j] == 2) {
						queue.offer(new Node(i, j));
					}
				}
			}
			
			while (!queue.isEmpty()) {
				Node n = queue.poll();
				
				for (int i = 0; i < 4; ++i) {
					int newY = n.y + direction[i][0];
					int newX = n.x + direction[i][1];
					
					if (newY >= 0 && newY < N && newX >= 0 && newX < M) {
						if (virus[newY][newX] == 0) {
							virus[newY][newX] = 2;
							queue.offer(new Node(newY, newX));
						}
					}
				}
			}
			
			int spaceCount = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (virus[i][j] == 0) {
						spaceCount++;
					}
				}
			}
			
			result = Math.max(result, spaceCount);
			
			return;
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(i, j, wallCount + 1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            
            arr = new int[N][M];
            virus = new int[N][M];
            
            for (int i = 0; i < N; ++i) {
            	s = br.readLine().split(" ");
            	for (int j = 0; j < M; ++j) {
            		arr[i][j] = Integer.parseInt(s[j]);
            	}
            }
            
            for (int i = 0; i < N; ++i) {
            	for (int j = 0; j < M; ++j) {
            		if (arr[i][j] == 0) {
            			arr[i][j] = 1;
            			dfs(i, j, 1);
            			arr[i][j] = 0;
            		}
            	}
            }
            
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}