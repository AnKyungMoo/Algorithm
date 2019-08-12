import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int y;
	int x;
	int range;
	
	Node(int y, int x, int range) {
		this.y = y;
		this.x = x;
		this.range = range;
	}
}

public class Main {
	int N;
	int M;
	int K;
	int[][] arr;
	Node[] skills;
	boolean[] visit;
	int result;
	
	private void go(int index) {
		for (int i = 1; i <= skills[index].range; ++i) {
			int y = skills[index].y - i;
			int x = skills[index].x - i;
			int prevValue = arr[y][x];
			
			for (int a = 0; a < i * 2; ++a) {
				int temp = arr[y][x + 1];
				arr[y][x + 1] = prevValue;
				prevValue = temp;
				x++;
			}
			
			for (int a = 0; a < i * 2; ++a) {
				int temp = arr[y + 1][x];
				arr[y + 1][x] = prevValue;
				prevValue = temp;
				y++;
			}
			
			for (int a = 0; a < i * 2; ++a) {
				int temp = arr[y][x - 1];
				arr[y][x - 1] = prevValue;
				prevValue = temp;
				x--;
			}
			
			for (int a = 0; a < i * 2; ++a) {
				int temp = arr[y - 1][x];
				arr[y - 1][x] = prevValue;
				prevValue = temp;
				y--;
			}
		}
	}
	
	private void back(int index) {
		for (int i = 1; i <= skills[index].range; ++i) {
			int y = skills[index].y - i;
			int x = skills[index].x - i;
			int prevValue = arr[y][x];
			
			for (int a = 0; a < i * 2; ++a) {
				int temp = arr[y + 1][x];
				arr[y + 1][x] = prevValue;
				prevValue = temp;
				y++;
			}
			
			for (int a = 0; a < i * 2; ++a) {
				int temp = arr[y][x + 1];
				arr[y][x + 1] = prevValue;
				prevValue = temp;
				x++;
			}
			
			for (int a = 0; a < i * 2; ++a) {
				int temp = arr[y - 1][x];
				arr[y - 1][x] = prevValue;
				prevValue = temp;
				y--;
			}
			
			for (int a = 0; a < i * 2; ++a) {
				int temp = arr[y][x - 1];
				arr[y][x - 1] = prevValue;
				prevValue = temp;
				x--;
			}
		}
	}
	
	private void dfs() {
		boolean flag = false;
		
		for (int i = 0; i < K; ++i) {
			if (!visit[i]) {
				flag = true;
			}
		}
		
		if (!flag) {
			for (int a = 0; a < N; ++a) {
				int temp = 0;
				for (int b = 0; b < M; ++b) {
					temp += arr[a][b];
				}
				
				result = Math.min(temp, result);
			}
			
			return;
		}
		
		for (int i = 0; i < K; ++i) {
			if (!visit[i]) {
				go(i);
				
				visit[i] = true;
				dfs();
				visit[i] = false;
				
				back(i);
			}
		}
	}
	
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] s = br.readLine().split(" ");

			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			K = Integer.parseInt(s[2]);
			arr = new int[N][M];
			skills = new Node[K];
			visit = new boolean[K];
			result = 1000000;
			
			for (int i = 0; i < N; ++i) {
				s = br.readLine().split(" ");
				
				for (int j = 0; j < M; ++j) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			for (int i = 0; i < K; ++i) {
				s = br.readLine().split(" ");
				
				skills[i] = new Node(Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]) - 1, Integer.parseInt(s[2]));
			}
			
			for (int i = 0; i < K; ++i) {
				// 회전
				go(i);
				
				// dfs
				visit[i] = true;
				dfs();
				visit[i] = false;
				
				// 되돌리기
				back(i);
			}
			
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}