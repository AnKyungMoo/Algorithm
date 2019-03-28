import java.io.*;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);

            char[][] arr = new char[N + 1][M + 1];

            for (int i = 1; i <= N; ++i) {
                String line = br.readLine();
                for (int j = 1; j <= M; ++j) {
                    arr[i][j] = line.charAt(j - 1);
                }
            }

            int min = 2501;
            int curr;
            char[] colors = {'B', 'W'};
            for (int i = 1; i <= N && N - i >= 7; ++i) {
                for (int j = 1; j <= M && M - j >= 7; ++j) {
                    // (i, j) 시작점
                    // B
                    curr = 0;
                    int colorIndex = 0;
                    for (int y = i; y <= i + 7; ++y) {
                        for (int x = j; x <= j + 7; ++x) {
                            if (arr[y][x] != colors[colorIndex]) {
                                curr++;
                            }
                            colorIndex = colorIndex ^ 1;
                        }
                        colorIndex = colorIndex ^ 1;
                    }

                    min = Math.min(min, curr);

                    // W
                    curr = 0;
                    colorIndex = 1;
                    for (int y = i; y <= i + 7; ++y) {
                        for (int x = j; x <= j + 7; ++x) {
                            if (arr[y][x] != colors[colorIndex]) {
                                curr++;
                            }
                            colorIndex = colorIndex ^ 1;
                        }
                        colorIndex = colorIndex ^ 1;
                    }
                    min = Math.min(min, curr);
                }
            }

            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
