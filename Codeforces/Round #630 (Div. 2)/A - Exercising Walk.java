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
                int c = Integer.parseInt(s[2]);
                int d = Integer.parseInt(s[3]);

                s = br.readLine().split(" ");

                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                int x1 = Integer.parseInt(s[2]);
                int y1 = Integer.parseInt(s[3]);
                int x2 = Integer.parseInt(s[4]);
                int y2 = Integer.parseInt(s[5]);

                if ((x1 == x2 && a != 0 && b != 0) || (y1 == y2 && c != 0 && d != 0)) {
                    System.out.println("NO");
                    continue;
                }

                int garo = a - b;
                int sero = d - c;

                int u = x - garo;
                int v = y + sero;

                if (u >= x1 && u <= x2 && v >= y1 && v <= y2) {
                    System.out.println("YES");
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