import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int N;
    int[] arr;
    boolean[] visit;
    Queue<Integer> queue;

    private int dfs(int number) {
        if (visit[number]) {
            return 1;
        }

        queue.add(number);
        int result = 1;
        visit[number] = true;
        return result + dfs(arr[number]);
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int Q = Integer.parseInt(br.readLine());

            for (int q = 0; q < Q; ++q) {
                N = Integer.parseInt(br.readLine());
                arr = new int[N];
                visit = new boolean[N];
                queue = new LinkedList<>();
                String[] s = br.readLine().split(" ");

                for (int i = 0; i < N; ++i) {
                    arr[i] = Integer.parseInt(s[i]) - 1;
                }

                int[] result = new int[N];

                for (int i = 0; i < N; ++i) {
                    if (!visit[i]) {
                        visit[i] = true;
                        result[i] = dfs(arr[i]);

                        while (!queue.isEmpty()) {
                            int index = queue.poll();

                            result[index] = result[i];
                        }
                    }
                }

                for (int i = 0; i < N; ++i) {
                    System.out.print(result[i] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}