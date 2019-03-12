import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] strings = s.split(" ");

        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);

        long[] line = new long[N];
        long max = -1;
        for (int i = 0; i < N; ++i) {
            line[i] = Integer.parseInt(br.readLine());

            max = Math.max(max, line[i]);
        }

        long left = 1;
        long right = max;
        long prev = max;

        while (left < right) {
            long count = 0;
            for (int i = 0; i < N; ++i) {
                count += line[i] / right;
            }

            if (count < M) {
                prev = right;
                right = (left + right) / 2;
            } else {
                left = right;
                right = prev;
            }
        }

        System.out.println(right);
        br.close();
    }
}
