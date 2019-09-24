import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            char[] number = br.readLine().toCharArray();

            int index = 0;

            if (n == 1 && k != 0) {
                System.out.println("0");
            } else {
                if (k != 0 && number[index] != '1') {
                    number[index] = '1';
                    k--;
                }

                index++;
                while (k > 0 && n > index) {
                    if (number[index] != '0') {
                        number[index] = '0';
                        k--;
                    }

                    index++;
                }

                String result = String.valueOf(number);
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}