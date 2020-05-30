import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int N = Integer.parseInt(s[0]);
            int d = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int c = Integer.parseInt(s[3]);

            int[] arr = new int[N];
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int n = 0; n < N; ++n) {
                arr[n] = Integer.parseInt(br.readLine());
            }

            int result = 0;

            int left = 0;
            int right = k - 1;

            for (int i = 0; i < k; ++i) {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], 1);
                } else {
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
            }

            while (left < N) {
                int temp = 0;
                for (int item : map.keySet()) {
                    if (map.get(item) > 0) {
                        temp++;
                    }
                }

                if (!map.containsKey(c) || map.get(c) == 0) {
                    temp++;
                }

                result = Math.max(result, temp);

                map.put(arr[left], map.get(arr[left]) - 1);
                left++;

                right++;

                if (right == N) {
                    right = 0;
                }

                if (map.containsKey(arr[right])) {
                    map.put(arr[right], map.get(arr[right]) + 1);
                } else {
                    map.put(arr[right], 1);
                }
            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().solve();
    }
}