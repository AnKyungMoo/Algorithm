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

                boolean first = false;
                boolean second = false;

                if (a % 2 == 0) {
                    first = true;
                }

                if (b % 2 == 0) {
                    second = true;
                }

                if (first == second) {
                    if ((a / b) < b) {
                        System.out.println("NO");
                    } else {
                        System.out.println("YES");
                    }
                } else {
                    System.out.println("NO");
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