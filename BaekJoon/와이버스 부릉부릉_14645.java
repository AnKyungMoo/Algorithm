import java.io.*;

public class Main {
    private void solve() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();
            String[] temp = s.split(" ");

            int N = Integer.parseInt(temp[0]);

            for (int i = 0; i < N; ++i) {
                br.readLine();
            }

            System.out.println("비와이");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Main().solve();
    }
}