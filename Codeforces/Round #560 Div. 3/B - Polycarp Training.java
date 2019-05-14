import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Solution {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] arr = new int[N];

            int size = s.length;
            for (int i = 0; i < size; ++i) {
                arr[i] = Integer.parseInt(s[i]);
            }

            // avoid worst case
            Random random = new Random();
            for (int i = 0; i < arr.length; i++) {
                int tmp = arr[i];
                int r = random.nextInt(arr.length);
                arr[i] = arr[r];
                arr[r] = tmp;
            }

            Arrays.sort(arr);

            int result = 0;
            int day = 1;
            for (int i = 0; i < N; ++i) {
                if (day <= arr[i]) {
                    result++;
                    day++;
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}