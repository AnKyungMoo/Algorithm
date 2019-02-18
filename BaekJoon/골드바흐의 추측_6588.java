import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] arr = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        arr[0] = arr[1] = true;

        for (int i = 2; i < 1000001; ++i) {
            if (!arr[i]) {
                for (int j = 2; j < 1000001 / i; ++j) {
                    if (!arr[i * j]) {
                        arr[i * j] = true;
                    }
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;

        while (true) {
            a = Integer.parseInt(br.readLine());

            if (a == 0)
                break;

            for (int i = 2; i < 1000001; ++i) {
                if (!arr[i] && !arr[a - i]) {
                    System.out.println(a + " = " + i + " + " + (a - i));
                    break;
                }
            }
        }
    }
}
