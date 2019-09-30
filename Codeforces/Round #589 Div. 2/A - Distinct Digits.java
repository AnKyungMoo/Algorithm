import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
 
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int[] arr = new int[10];
 
            for (int i = a; i <= b; ++i) {
                Arrays.fill(arr, 0);
 
                int curr = i;
                while (curr > 0) {
                    arr[curr % 10]++;
                    curr /= 10;
                }
 
                boolean isSuccess = true;
                for (int j = 0; j < 10; ++j) {
                    if (arr[j] >= 2) {
                        isSuccess = false;
                        break;
                    }
                }
 
                if (isSuccess) {
                    System.out.println(i);
                    break;
                }
 
                if (i == b) {
                    System.out.println("-1");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        new Main().solve();
    }
}