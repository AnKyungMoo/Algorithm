import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine(), 10);

            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int max = 0;
            for (int i = 0; i < N; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
            }

            int M = Integer.parseInt(br.readLine());

            int left = 0, right = max;
            int result = 0;

            while (left <= right) {
                int mid = (left + right) / 2;

                long curr = 0;
                for (int i = 0; i < N; ++i) {
                    if (arr[i] > mid) {
                        curr += mid;
                    } else {
                        curr += arr[i];
                    }
                }

                if (curr > M) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                    result = mid;
                }
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