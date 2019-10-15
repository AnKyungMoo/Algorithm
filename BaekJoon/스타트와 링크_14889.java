import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Main {
	int N;
	int[][] arr;
	boolean[] visit;
	int divN;
	int minResult;
	
	private void dfs(int num, int count) {
		if (count == divN) {
			ArrayList<Integer> team1 = new ArrayList<>();
			ArrayList<Integer> team2 = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				if (visit[i]) {
					team1.add(i);
				} else {
					team2.add(i);
				}
			}
			// 가즈앙
			int team1Point = 0;
			for (int i = 0; i < team1.size(); ++i) {
				int item = team1.get(i);
				for (int j = 0; j < team1.size(); ++j) {
					if (i == j) {
						continue;
					}

					team1Point += arr[item][team1.get(j)];
				}
			}
			
			int team2Point = 0;
			for (int i = 0; i < team2.size(); ++i) {
				int item = team2.get(i);
				for (int j = 0; j < team2.size(); ++j) {
					if (i == j) {
						continue;
					}
					
					team2Point += arr[item][team2.get(j)];
				}
			}
			
			minResult = Math.min(minResult, Math.abs(team1Point - team2Point));
			
			return;
		}
		
		for (int i = num + 1; i < N; ++i) {
			if (visit[i]) {
				continue;
			}
			
			visit[i] = true;
			dfs(i, count + 1);
			visit[i] = false;
		}
	}
	
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			N = Integer.parseInt(br.readLine());
			divN = N / 2;
			arr = new int[N][N];
			visit = new boolean[N];
			minResult = 2147483647;
			
			String[] s;
			for (int i = 0; i < N; ++i) {
				s = br.readLine().split(" ");
				
				for (int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			for (int i = 0; i < N; ++i) {
				visit[i] = true;
				dfs(i, 1);
				visit[i] = false;
			}
			
			System.out.println(minResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
