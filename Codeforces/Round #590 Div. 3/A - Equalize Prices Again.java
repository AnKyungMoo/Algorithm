import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; ++t) {
                int sum = 0;

                int n = Integer.parseInt(br.readLine());
                String[] s = br.readLine().split(" ");

                for (int i = 0; i < n; ++i) {
                    sum += Integer.parseInt(s[i]);
                }

                int result = sum / n;

                if (result * n  < sum) {
                    result++;
                }

                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}