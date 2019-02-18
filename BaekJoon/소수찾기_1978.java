import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] arr = new boolean[1001];

    public static void main(String[] args) throws IOException {
        int result = 0;
        arr[0] = arr[1] = true;

        for (int i = 2; i < 1001; ++i) {
            if (!arr[i]) {
                for (int j = 2; j < 1001 / i; ++j) {
                    if (!arr[i * j]) {
                        arr[i * j] = true;
                    }
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            if (!arr[Integer.parseInt(st.nextToken())]) {
                result++;
            }
        }

        System.out.println(result);
    }
}
