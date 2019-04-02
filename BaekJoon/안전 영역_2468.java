import java.io.*;
import java.util.Arrays;

public class Main {
    int[][] board;
    private void dfs(int i, int j, int height) {
        if (board[i][j] <= height) {
            return;
        }

        board[i][j] = -1;

        dfs(i, j - 1, height);
        dfs(i - 1, j, height);
        dfs(i + 1, j, height);
        dfs(i, j + 1, height);
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N + 2][N + 2];
            board = new int[N + 2][N + 2];

            for (int i = 0; i <= N + 1; ++i) {
                Arrays.fill(arr[i], -1);
            }

            String[] s;
            int max = 0;
            for (int i = 1; i <= N; ++i) {
                s = br.readLine().split(" ");

                for (int j = 1; j <= N; ++j) {
                    arr[i][j] = Integer.parseInt(s[j-1]);
                    max = Math.max(max, arr[i][j]);
                }
            }

            int result = 0;
            for (int height = 0; height <= max; ++height) {
                for (int i = 0; i <= N + 1; ++i) {
                    board[i] = arr[i].clone();
                }
                int tempResult = 0;
                for (int i = 1; i <= N; ++i) {
                    for (int j = 1; j <= N; ++j) {
                        if (board[i][j] > height) {
                            dfs(i, j, height);
                            tempResult++;
                        }
                    }
                }

                result = Math.max(result, tempResult);
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