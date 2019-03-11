import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        int[] mArray = new int[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; ++i) {
            mArray[i] = Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; ++i) {
            int left = 0;
            int right = arr.length - 1;

            while (left < right) {
                int curr = (left + right) / 2;

                if (mArray[i] > arr[curr]) {
                    left = curr + 1;
                } else {
                    right = curr;
                }
            }

            int count = 0;
            if (mArray[i] == arr[right]) {
                count = map.get(mArray[i]);
            }

            sb.append(count).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
