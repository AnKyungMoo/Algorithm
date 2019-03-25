import java.io.*;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            String[] s = br.readLine().split(" ");
            int[] arr = new int[n];
            int[] memo = new int[n];

            for (int i = 0; i < n; ++i) {
                arr[i] = Integer.parseInt(s[i]);
            }

            memo[0] = arr[0];
            int max = memo[0];
            for (int i = 1; i < n; ++i) {
                if (memo[i-1] < 0) {
                    memo[i] = arr[i];
                } else {
                    memo[i] = memo[i - 1] + arr[i];
                }
                max = Math.max(max, memo[i]);
            }

            System.out.println(max);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Main().solve();
    }
}