import java.io.*;

public class Main {
    int N;
    int[][] arr;
    int[][] direct = {{0, 1}, {1, 1}, {1, 0}};
    int result;

    private void dfs(int y, int x, int flag) {
        if (y == N && x == N) {
            result++;
            return;
        }

        if (flag == 0) {
            int newY = y + direct[0][0];
            int newX = x + direct[0][1];

            if (newY <= N && newY > 0 && newX <= N && newX > 0 && arr[newY][newX] == 0) {
                dfs(newY, newX, 0);
            }

            newY = y + direct[1][0];
            newX = x + direct[1][1];

            if (newY <= N && newY > 0 && newX <= N && newX > 0 &&
                    arr[newY][newX] == 0 && arr[newY][newX - 1] == 0 && arr[newY - 1][newX] == 0) {
                dfs(newY, newX, 1);
            }
        } else if (flag == 1) {
            int newY = y + direct[0][0];
            int newX = x + direct[0][1];

            if (newY <= N && newY > 0 && newX <= N && newX > 0 && arr[newY][newX] == 0) {
                dfs(newY, newX, 0);
            }

            newY = y + direct[1][0];
            newX = x + direct[1][1];

            if (newY <= N && newY > 0 && newX <= N && newX > 0 &&
                    arr[newY][newX] == 0 && arr[newY][newX - 1] == 0 && arr[newY - 1][newX] == 0) {
                dfs(newY, newX, 1);
            }

            newY = y + direct[2][0];
            newX = x + direct[2][1];

            if (newY <= N && newY > 0 && newX <= N && newX > 0 && arr[newY][newX] == 0) {
                dfs(newY, newX, 2);
            }
        } else {
            int newY = y + direct[1][0];
            int newX = x + direct[1][1];

            if (newY <= N && newY > 0 && newX <= N && newX > 0 &&
                    arr[newY][newX] == 0 && arr[newY][newX - 1] == 0 && arr[newY - 1][newX] == 0) {
                dfs(newY, newX, 1);
            }

            newY = y + direct[2][0];
            newX = x + direct[2][1];

            if (newY <= N && newY > 0 && newX <= N && newX > 0 && arr[newY][newX] == 0) {
                dfs(newY, newX, 2);
            }
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            result = 0;
            arr = new int[N + 1][N + 1];

            String[] s;
            for (int i = 1; i <= N; ++i) {
                s = br.readLine().split(" ");

                for (int j = 1; j <= N; ++j) {
                    arr[i][j] = Integer.parseInt(s[j - 1]);
                }
            }

            dfs(1, 2, 0);

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}