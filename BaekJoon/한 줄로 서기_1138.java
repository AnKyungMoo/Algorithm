import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int[] count = new int[N + 1];
            int[] result = new int[N + 1];

            Arrays.fill(result, -1);

            String[] s = br.readLine().split(" ");

            for (int i = 1; i <= N; ++i) {
                count[i] = Integer.parseInt(s[i - 1]);
            }

            for (int i = 1; i <= N; ++i) {
                int cnt = count[i];
                for (int j = 1; j <= N; ++j) {
                    if (cnt == 0 && result[j] == -1) {
                        result[j] = i;
                        break;
                    }

                    if (result[j] == -1) {
                        cnt--;
                    }
                }
            }

            for (int i = 1; i <= N; ++i) {
                System.out.print(result[i] + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}