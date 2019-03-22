import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine(), 10);

            int count = 9;
            int i = 1;
            int sum = 0;
            while (N > 0) {
                if (N >= count) {
                    N -= count;
                    sum += (count * i);
                    i++;
                    count *= 10;
                } else {
                    sum += (N * i);
                    N -= count;
                }
            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
