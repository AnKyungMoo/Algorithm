import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Main {
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] s = br.readLine().split(" ");
			int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
			
			int N = Integer.parseInt(s[0]);	// 배열 크기
			int M = Integer.parseInt(s[1]);	// 나무 개수
			int K = Integer.parseInt(s[2]);	// K년
			
			int[][] A = new int[N][N];
			int[][] nutrient = new int[N][N];
			
			PriorityQueue<Integer>[][] board = new PriorityQueue[N][N];
			
			for (int i = 0; i < N; ++i) {
				s = br.readLine().split(" ");
				for (int j = 0; j < N; ++j) {
					A[i][j] = Integer.parseInt(s[j]);
					nutrient[i][j] = 5;
					board[i][j] = new PriorityQueue<>();
				}
			}
			
			// 맨처음 나무 심기
			for (int i = 0; i < M; ++i) {
				s = br.readLine().split(" ");
				board[Integer.parseInt(s[0]) - 1][Integer.parseInt(s[1]) - 1].add(Integer.parseInt(s[2]));
			}
			
			for (int k = 0; k < K; ++k) {
				for (int i = 0; i < N; ++i) {
					for (int j = 0; j < N; ++j) {
						ArrayList<Integer> tempTree = new ArrayList<>();
						int tempNutrient = 0;
						while (!board[i][j].isEmpty()) {
							int item = board[i][j].poll();
							if (item > nutrient[i][j]) {
								// 죽는다
								tempNutrient += item / 2;
							} else {
								// 영양소 먹고 성장
								nutrient[i][j] -= item;
								tempTree.add(item + 1);
							}
						}
						
						nutrient[i][j] += tempNutrient;
						for (int item : tempTree) {
							board[i][j].add(item);
						}
					}
				}
				
				for (int i = 0; i < N; ++i) {
					for (int j = 0; j < N; ++j) {
						// 돌아서 번식하자
						for (int tree : board[i][j]) {
							if (tree % 5 == 0) {
								for (int q = 0; q < direct.length; ++q) {
									int newY = i + direct[q][0];
									int newX = j + direct[q][1];
									
									if (newY >= N || newY < 0 || newX >= N || newX < 0) {
										continue;
									}
									
									board[newY][newX].add(1);
								}
							}
						}
						
						// 양분 넣기
						nutrient[i][j] += A[i][j];
					}
				}
			}
			
			int result = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					while (!board[i][j].isEmpty()) {
						board[i][j].poll();
						result++;
					}
				}
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
