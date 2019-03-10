import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] strings = s.split(" ");

        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);
        int K = Integer.parseInt(strings[2]);

        int g = N / 2;
        int n = N % 2;

        int result;
        if (g > M) {
            result = M;
            n = (g - M) * 2;
        } else if (g == M) {
            result = g;
        } else {
            result = g;
            n += (M - g);
        }

        if (K > n) {
            K -= n;

            int mok = K / 3;
            int nam = K % 3;

            result -= mok;

            if (nam != 0) {
                result--;
            }
        }

        System.out.println(result);
    }
}