import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            String[] s = br.readLine().split(" ");
            String[] bc = br.readLine().split(" ");

            int B = Integer.parseInt(bc[0]);
            int C = Integer.parseInt(bc[1]);

            long result = 0;
            for (int i = 0; i < N; ++i) {
                int num = Integer.parseInt(s[i]) - B;

                if (num > 0) {
                    result++;

                    if (num % C == 0) {
                        result += num / C;
                    } else {
                        result += num / C + 1;
                    }
                } else {
                    result++;
                }
            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().solve();
    }
}