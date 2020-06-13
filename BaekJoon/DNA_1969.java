import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);

            String[] arr = new String[N];

            for (int i = 0; i < N; ++i) {
                arr[i] = br.readLine();
            }

            String result = "";
            int HammingDistance = 0;
            for (int m = 0; m < M; ++m) {
                int[] keys = new int[27];
                for (int n = 0; n < N; ++n) {
                    keys[arr[n].charAt(m) - 'A']++;
                }

                int tempInt = 0;
                char tempChar = '0';
                for (int i = 0; i < 27; ++i) {
                    if (tempInt < keys[i]) {
                        tempInt = keys[i];
                        tempChar = (char)(i + 'A');
                    }
                }

                HammingDistance += (N - tempInt);
                result += tempChar;
            }

            System.out.println(result);
            System.out.println(HammingDistance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}