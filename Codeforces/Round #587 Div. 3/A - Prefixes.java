import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            char[] chars = s.toCharArray();

            int result = 0;
            for (int i = 0; i < n; i += 2) {
                if (chars[i] == 'a' && chars[i + 1] == 'a') {
                    chars[i] = 'b';
                    result++;
                } else if (chars[i] == 'b' && chars[i + 1] == 'b') {
                    chars[i] = 'a';
                    result++;
                }
            }

            System.out.println(result);
            for (int i = 0; i < n; ++i) {
                System.out.print(chars[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}