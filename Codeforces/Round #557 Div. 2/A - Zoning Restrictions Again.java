import java.io.*;
import java.util.Arrays;

public class Solution {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int N = Integer.parseInt(s[0]);
            int H = Integer.parseInt(s[1]);
            int M = Integer.parseInt(s[2]);

            int[] arr = new int[N + 1];
            Arrays.fill(arr, -1);

            for (int m = 1; m <= M; ++m) {
                String[] restriction = br.readLine().split(" ");

                int start = Integer.parseInt(restriction[0]);
                int end = Integer.parseInt(restriction[1]);
                int value = Integer.parseInt(restriction[2]);

                for (int a = start; a <= end; ++a) {
                    if (arr[a] == -1) {
                        arr[a] = value;
                    } else {
                        arr[a] = Math.min(arr[a], value);
                    }
                }
            }

            int result = 0;
            for (int i = 1; i <= N; ++i) {
                if (arr[i] == -1) {
                    arr[i] = H;
                }
                result += (arr[i] * arr[i]);
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