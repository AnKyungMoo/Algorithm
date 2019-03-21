import java.io.*;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String[] s = br.readLine().split(" ");

                // 입력
                int N = Integer.parseInt(s[0]);
                int M = Integer.parseInt(s[1]);

                if (N == 0 && M == 0) {
                    break;
                }

                int[][] arr = new int[N][M];
                int[][] dp = new int[N][M];

                for (int i = 0; i < N; ++i) {
                    s = br.readLine().split(" ");
                    for (int j = 0; j < M; ++j) {
                        arr[i][j] = Integer.parseInt(s[j]);
                    }
                }

                // 출력
                int max = 0;

                for (int i = 0; i < N; ++i) {
                    if (arr[i][0] == 1) {
                        dp[i][0] = 1;
                        max = 1;
                    }
                }

                for (int i = 0; i < M; ++i) {
                    if (arr[0][i] == 1) {
                        dp[0][i] = 1;
                        max = 1;
                    }
                }

                for (int i = 1; i < N; ++i) {
                    for (int j = 1; j < M; ++j) {
                        if (arr[i][j] == 1) {
                            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                            max = Math.max(max, dp[i][j]);
                        }
                    }
                }

                sb.append(max).append("\n");
            }

            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
