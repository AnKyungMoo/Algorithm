import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            int[] prime = {2, 3, 5, 7, 11, 13, 17};
            final int SIZE = 18;

            for (int t = 1; t <= T; ++t) {
                String[] s = br.readLine().split(" ");

                double skillOfMasterA = Integer.parseInt(s[0]) * 0.01;
                double skillOfMasterB = Integer.parseInt(s[1]) * 0.01;

                double A = 0.0;
                double B = 0.0;
                for (int value : prime) {
                    long temp = 1;
                    for (int j = 0; j < value; ++j) {
                        temp *= (double) (SIZE - j) / (j + 1);
                    }

                    A += Math.pow(skillOfMasterA, value) * Math.pow(1 - skillOfMasterA, (SIZE - value)) * temp;
                    B += Math.pow(skillOfMasterB, value) * Math.pow(1 - skillOfMasterB, (SIZE - value)) * temp;
                }

                double result = A * (1 - B) + B * (1 - A) + A * B;

                System.out.println("#" + t + " " + String.format("%.6f", result));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
