import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = new long[100001];
        TreeMap<Long, Integer> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; ++i) {
            arr[i] = Long.parseLong(br.readLine());
            map.put(arr[i], 0);
        }

        for (int i = 1; i <= N; ++i) {
            map.put(arr[i], map.get(arr[i]) + 1);
        }

        long max = map.firstKey();
        int max_count = map.get(max);

        for (Long i : map.keySet()) {
            if (map.get(i) > max_count) {
                max = i;
                max_count = map.get(i);
            }
        }

        System.out.println(max);
    }
}