import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    String[] s;
    int[] arr;
    boolean[] visit;
    boolean isCorrect;
    int sumA;
    int sumB;

    private void dfsB(int count) {
        if (count == 0) {
            if (sumA == sumB) {
                isCorrect = true;
            }

            return;
        }

        for (int i = 0; i < s.length; ++i) {
            if (visit[i]) {
                continue;
            }

            sumB += arr[i];
            visit[i] = true;
            dfsB(count - 1);
            sumB -= arr[i];
            visit[i] = false;
        }
    }

    private void dfsA(int count) {
        dfsB(s.length - count);

        for (int i = 0; i < s.length; ++i) {
            if (visit[i]) {
                continue;
            }

            sumA += arr[i];
            visit[i] = true;
            dfsA(count + 1);
            sumA -= arr[i];
            visit[i] = false;
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            s = br.readLine().split(" ");
            arr = new int[s.length];
            visit = new boolean[s.length];
            isCorrect = false;
            sumA = 0;
            sumB = 0;

            for (int i = 0; i < s.length; ++i) {
                arr[i] = Integer.parseInt(s[i]);
            }

            for (int i = 0; i < s.length; ++i) {
                sumA += arr[i];
                visit[i] = true;
                dfsA(1);
                sumA -= arr[i];
                visit[i] = false;
            }

            if (isCorrect) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}