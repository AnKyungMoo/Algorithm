import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        StringBuilder sb = new StringBuilder();

        while (!(s = br.readLine()).equals("0 0")) {
            String[] temp = s.split(" ");

            int w = Integer.parseInt(temp[0]);
            int h = Integer.parseInt(temp[1]);

            board = new int[h + 2][w + 2];

            for (int i = 1; i <= h; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for (int j = 1; j <= w; ++j) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for (int i = 1; i <= h; ++i) {
                for (int j = 1; j <= w; ++j) {
                    if (board[i][j] != 0) {
                        dfs(i, j);
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x) {
        if (board[y][x] == 0) {
            return;
        }

        board[y][x] = 0;

        dfs(y, x + 1);
        dfs(y, x - 1);
        dfs(y + 1, x);
        dfs(y - 1, x);
        dfs(y + 1, x + 1);
        dfs(y - 1, x + 1);
        dfs(y + 1, x - 1);
        dfs(y - 1, x - 1);
    }
}
