import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            int[][] map = new int[T + 1][T + 1];
            boolean[] visit = new boolean[T + 1];

            int N = Integer.parseInt(br.readLine());
            for (int n = 0; n < N; ++n) {
                String[] s = br.readLine().split(" ");

                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                map[a][b] = 1;
                map[b][a] = 1;
            }

            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            visit[1] = true;

            int result = 0;
            while (!stack.isEmpty()) {
                int curr = stack.pop();

                for (int i = 1; i <= T; ++i) {
                    if (visit[i]) {
                        continue;
                    }

                    if (map[i][curr] != 1) {
                        continue;
                    }

                    visit[i] = true;
                    result++;
                    stack.push(i);
                }
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