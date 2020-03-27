import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; ++t) {
                String[] s = br.readLine().split(" ");

                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                if (a % b != 0) {
                    System.out.println(b - (a % b));
                } else {
                    System.out.println(a % b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main().solve();
    }
}