import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] coins = new int[11];

        String s = br.readLine();
        String[] temps = s.split(" ");

        int N = Integer.parseInt(temps[0]);
        int K = Integer.parseInt(temps[1]);

        for (int i = 1; i <= N; ++i) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int index = N;
        int result = 0;

        while (K > 0) {
            result += K / coins[index];
            K %= coins[index--];
        }

        System.out.println(result);
    }
}
