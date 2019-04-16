import java.io.*;

public class Main {
    public void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int A = Integer.parseInt(br.readLine());
            int B = Integer.parseInt(br.readLine());
            int C = Integer.parseInt(br.readLine());

            int calc = A * B * C;

            int[] arr = new int[10];

            String result = String.valueOf(calc);

            for (int i = 0; i < result.length(); ++i) {
                arr[result.charAt(i) - '0']++;
            }

            for (int i = 0; i < 10; ++i) {
                System.out.println(arr[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}