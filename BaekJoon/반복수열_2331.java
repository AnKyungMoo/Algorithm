import java.io.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[1000001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] strings = s.split(" ");

        int A = Integer.parseInt(strings[0]);
        int P = Integer.parseInt(strings[1]);

        System.out.println(length(A, P, 1));
    }

    static int next(int a, int p) {
        int result = 0;

        while (a / 10 >= 1) {
            int num = a % 10;
            a /= 10;

            result += (int)Math.pow((double)num, (double)p);
        }

        result += (int)Math.pow((double)a, (double)p);

        return result;
    }

    static int length(int a, int p, int count) {
        if (arr[a] != 0) {
            return arr[a] - 1;
        }

        arr[a] = count;

        int b = next(a, p);

        return length(b, p, count + 1);
    }
}