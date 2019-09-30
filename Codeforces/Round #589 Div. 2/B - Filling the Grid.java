import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    private int calcPow(int count) {
        int result = 1;
 
        for (int i = 0; i < count; ++i) {
            result = (result * 2) % 1000000007;
        }
 
        return result;
    }
 
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
 
            int h = Integer.parseInt(s[0]);
            int w = Integer.parseInt(s[1]);
 
            int[][] arr = new int[h][w];
 
            for (int i = 0; i < h; ++i) {
                Arrays.fill(arr[i], -1);
            }
 
            s = br.readLine().split(" ");
            for (int i = 0; i < s.length; ++i) {
                int temp = Integer.parseInt(s[i]);
 
                int k;
                for (k = 0; k < temp; ++k) {
                    arr[i][k] = 1;
                }
 
                if (k < w) {
                    arr[i][k] = 0;
                }
            }
 
            s = br.readLine().split(" ");
            for (int i = 0; i < s.length; ++i) {
                int temp = Integer.parseInt(s[i]);
 
                int k;
                for (k = 0; k < temp; ++k) {
                    if (arr[k][i] == 0) {
                        System.out.println("0");
                        return;
                    }
                    arr[k][i] = 1;
                }
 
                if (k < h) {
                    if (arr[k][i] == 1) {
                        System.out.println("0");
                        return;
                    }
                    arr[k][i] = 0;
                }
            }
 
            int minusCount = 0;
            for (int i = 0; i < h; ++i) {
                for (int j = 0; j < w; ++j) {
                    if (arr[i][j] == -1) {
                        minusCount++;
                    }
                }
            }
 
            if (minusCount == 0) {
                System.out.println("1");
            } else {
                System.out.println(calcPow(minusCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        new Main().solve();
    }
}