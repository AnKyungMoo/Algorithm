import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        int[] mArray = new int[M];

        for (int i = 0; i < M; ++i) {
            mArray[i] = Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            int left = 0;
            int right = arr.length - 1;
            int position = -1;

            while (left <= right) {
                int curr = (left + right) / 2;
                if (mArray[i] < arr[curr]) {
                    right = curr - 1;
                } else if (mArray[i] == arr[curr]) {
                    position = curr;
                    break;
                } else {
                    left = curr + 1;
                }
            }

            if (position != -1) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
