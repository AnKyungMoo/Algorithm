import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    int M;
    int N;
    int K;
    boolean[][] map;
    int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int result;

    private void dfs(int y, int x) {
        for (int i = 0; i < 4; ++i) {
            int newY = y + direct[i][0];
            int newX = x + direct[i][1];

            if (newY >= M || newY < 0 || newX >= N || newX < 0) {
                continue;
            }

            if (map[newY][newX]) {
                continue;
            }

            map[newY][newX] = true;
            result++;
            dfs(newY, newX);
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            M = Integer.parseInt(s[0]);
            N = Integer.parseInt(s[1]);
            K = Integer.parseInt(s[2]);

            map = new boolean[M][N];

            for (int k = 0; k < K; ++k) {
                s = br.readLine().split(" ");
                int x1 = Integer.parseInt(s[0]);
                int y1 = Integer.parseInt(s[1]);
                int x2 = Integer.parseInt(s[2]);
                int y2 = Integer.parseInt(s[3]);

                int diffX = x2 - x1;
                int diffY = y2 - y1;

                for (int y = y1; y < y1 + diffY; ++y) {
                    for (int x = x1; x < x1 + diffX; ++x) {
                        map[y][x] = true;
                    }
                }
            }

            ArrayList<Integer> resultList = new ArrayList<>();

            for (int i = 0; i < M; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (!map[i][j]) {
                        result = 1;
                        map[i][j] = true;
                        dfs(i, j);
                        resultList.add(result);
                    }
                }
            }

            System.out.println(resultList.size());
            Collections.sort(resultList);
            for (int item : resultList) {
                System.out.print(item + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}