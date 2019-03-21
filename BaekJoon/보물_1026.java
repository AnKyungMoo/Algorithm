import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine(), 10);

            Integer[] A = new Integer[N];
            Integer[] B = new Integer[N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; ++i) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; ++i) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B, Collections.reverseOrder());

            int result = 0;
            for (int i = 0; i < N; ++i) {
                result += A[i] * B[i];
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
