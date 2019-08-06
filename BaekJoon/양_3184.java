import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Point {
	int i;
	int j;
	char type;
	
	Point(int i, int j, char type) {
		this.i = i;
		this.j = j;
		this.type = type;
	}
}

public class Main {
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			char[][] map = new char[N][M];
			
			for (int n = 0; n < N; ++n) {
				String temp = br.readLine();
				
				for (int m = 0; m < M; ++m) {
					map[n][m] = temp.charAt(m);
				}
			}
			
			int resultO = 0;
			int resultV = 0;
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (map[i][j] == 'v' || map[i][j] == 'o') {
						Queue<Point> q = new LinkedList<>();
						
						int tempO = 0;
						int tempV = 0;
						
						if (map[i][j] == 'v') {
							tempV++;
						} else {
							tempO++;
						}
						
						q.add(new Point(i, j, map[i][j]));
						map[i][j] = '#';
						
						while (!q.isEmpty()) {
							Point p = q.poll();
							
							for (int x = 0; x < 4; ++x) {
								int newI = p.i + direct[x][0];
								int newJ = p.j + direct[x][1];
								
								if (newI >= 0 && newI < N && newJ >= 0 && newJ < M && map[newI][newJ] != '#') {
									if (map[newI][newJ] == 'o') {
										tempO++;
									} else if (map[newI][newJ] == 'v') {
										tempV++;
									}

									q.offer(new Point(newI, newJ, map[newI][newJ]));
									map[newI][newJ] = '#';
								}
							}
						}
						
						if (tempV >= tempO) {
							resultV += tempV;
						} else {
							resultO += tempO;
						}
					}
				}
			}
			
			System.out.println(resultO + " " + resultV);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}