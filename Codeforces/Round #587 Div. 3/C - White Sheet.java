import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            s = br.readLine().split(" ");
            int x3 = Integer.parseInt(s[0]);
            int y3 = Integer.parseInt(s[1]);
            int x4 = Integer.parseInt(s[2]);
            int y4 = Integer.parseInt(s[3]);

            s = br.readLine().split(" ");
            int x5 = Integer.parseInt(s[0]);
            int y5 = Integer.parseInt(s[1]);
            int x6 = Integer.parseInt(s[2]);
            int y6 = Integer.parseInt(s[3]);

            String result = "YES";
            if (x3 <= x1 && x4 >= x5 && x6 >= x2 &&
                    y4 >= y2 && y6 >= y2 && y3 <= y1 && y5 <= y1) {
                result = "NO";
            }

            if (x5 <= x1 && x6 >= x3 && x4 >= x2 &&
                    y4 >= y2 && y6 >= y2 && y3 <= y1 && y5 <= y1) {
                result = "NO";
            }

            if (x3 <= x1 && x4 >= x2 && x5 <= x1 && x6 >= x2 &&
                    y4 >= y2 && y5 <= y1 && y6 >= y3) {
                result = "NO";
            }

            if (x3 <= x1 && x4 >= x2 && x5 <= x1 && x6 >= x2 &&
                    y6 >= y2 && y3 <= y1 && y4 >= y5) {
                result = "NO";
            }

            if (x1 >= x3 && x2 <= x4 && y1 >= y3 && y2 <= y4) {
                result = "NO";
            }

            if (x1 >= x5 && x2 <= x6 && y1 >= y5 && y2 <= y6) {
                result = "NO";
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