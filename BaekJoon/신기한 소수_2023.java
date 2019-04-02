import java.io.*;
import java.util.ArrayList;

public class Main {
    ArrayList<Integer> result;

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int num, int count) {
        if (!isPrime(num)) {
            return;
        }

        if (count == 1) {
            result.add(num);
            return;
        }

        num *= 10;

        for (int i = 0; i <= 9; ++i) {
            dfs(num + i, count - 1);
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            result = new ArrayList<>();
            int[] arr = {2, 3, 5, 7};

            for (int i : arr) {
                dfs(i, N);
            }

            StringBuilder sb = new StringBuilder();
            for (Integer i : result) {
                sb.append(i).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}