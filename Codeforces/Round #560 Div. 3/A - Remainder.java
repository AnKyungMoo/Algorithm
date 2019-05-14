import java.io.*;

public class Solution {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            String input = br.readLine();

            int n = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            int y = Integer.parseInt(s[2]);

            int result = 0;
            for (int i = n - x; i < n; ++i) {
                if (i == n - y - 1) {
                    if (input.charAt(i) == '0') {
                        result++;
                    }
                }
                else {
                    if (input.charAt(i) == '1') {
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
        new Solution().solve();
    }
}