import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; ++t) {
                int n = Integer.parseInt(br.readLine());

                String s = br.readLine();

                StringBuilder resultBig = new StringBuilder("1");
                StringBuilder resultSmall = new StringBuilder("1");
                boolean isDiff = false;

                for (int i = 1; i < n; ++i) {
                    if (!isDiff) {
                        if (s.charAt(i) == '0') {
                            resultBig.append("0");
                            resultSmall.append("0");
                        } else if (s.charAt(i) == '1') {
                            resultBig.append("1");
                            resultSmall.append("0");
                            isDiff = true;
                        } else if (s.charAt(i) == '2') {
                            resultBig.append("1");
                            resultSmall.append("1");
                        }
                    } else {
                        if (s.charAt(i) == '0') {
                            resultBig.append("0");
                            resultSmall.append("0");
                        } else if (s.charAt(i) == '1') {
                            resultBig.append("0");
                            resultSmall.append("1");
                            isDiff = true;
                        } else if (s.charAt(i) == '2') {
                            resultBig.append("0");
                            resultSmall.append("2");
                        }
                    }
                }

                System.out.println(resultBig.toString());
                System.out.println(resultSmall.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main().solve();
    }
}