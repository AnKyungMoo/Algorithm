import java.io.*;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();
            String[] temps = s.split(" ");

            int A = Integer.parseInt(temps[0], 10);
            int B = Integer.parseInt(temps[1], 10);
            int V = Integer.parseInt(temps[2], 10);

            int curr = 0;
            int result = 0;
            while (true) {
                curr += A;
                result++;
                if (curr >= V) {
                    break;
                }
                curr -= B;
            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}