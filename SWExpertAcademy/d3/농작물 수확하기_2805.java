import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; ++t) {
                int N = Integer.parseInt(br.readLine());
                int[][] arr = new int[N][N];

                int result = 0;

                for (int i = 0; i < N; ++i) {
                    String s = br.readLine();
                    for (int j = 0; j < N; ++j) {
                        arr[i][j] = s.charAt(j) - '0';
                        result += arr[i][j];
                    }
                }

                int mid = N / 2;

                // 왼쪽 위
                for (int i = 0; i < mid; ++i) {
                    for (int j = 0; j < mid - i; ++j) {
                        result -= arr[i][j];
                    }
                }

                // 왼쪽 아래
                for (int i = mid + 1; i < N; ++i) {
                    for (int j = 0; j < i - mid; ++j) {
                        result -= arr[i][j];
                    }
                }

                // 오른쪽 위
                for (int i = 0; i < mid; ++i) {
                    for (int j = mid + 1 + i; j < N; ++j) {
                        result -= arr[i][j];
                    }
                }

                // 오른쪽 아래
                for (int i = mid + 1; i < N; ++i) {
                    for (int j = N - 1; j >= N - i + mid; --j) {
                        result -= arr[i][j];
                    }
                }

                sb.append("#").append(t).append(" ").append(result).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
