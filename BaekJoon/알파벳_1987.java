import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1987 {
	HashMap<Character, Boolean> map;
	char[][] board;
	int R;
	int C;
	int result;
	int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	private void dfs(int y, int x, int count) {
		for (int i = 0; i < 4; ++i) {
			int newY = y + direct[i][0];
			int newX = x + direct[i][1];
			
			if (newY >= R || newY < 0 || newX >= C || newX < 0) {
				continue;
			}
			
			if (map.containsKey(board[newY][newX])) {
				if (map.get(board[newY][newX])) {
					// 암것도 안함
				} else {
					map.put(board[newY][newX], true);
					dfs(newY, newX, count + 1);
					map.put(board[newY][newX], false);
				}
			} else {
				map.put(board[newY][newX], true);
				dfs(newY, newX, count + 1);
				map.put(board[newY][newX], false);
			}
		}
		
		result = Math.max(result, count);
	}
	
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] s = br.readLine().split(" ");
			
			R = Integer.parseInt(s[0]);
			C = Integer.parseInt(s[1]);
			board = new char[R][C];
			map = new HashMap<>();
			result = 0;
			
			String input;
			for (int i = 0; i < R; ++i) {
				input = br.readLine();
				
				for (int j = 0; j < C; ++j) {
					board[i][j] = input.charAt(j);
				}
			}
			
			map.put(board[0][0], true);
			dfs(0, 0, 1);
			
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main_1987().solve();
	}
}