import java.io.*;
import java.util.HashSet;

public class Main {
    HashSet<String> set;
    String[][] board;

    private void dfs(int i, int j, String s, int count) {
        if (i < 0 || j < 0 || i >= 5 || j >= 5) {
            return;
        }

        s += board[i][j];
        count++;

        if (count >= 6) {
            set.add(s);
            return;
        }

        dfs(i+1, j, s, count);
        dfs(i, j+1, s, count);
        dfs(i-1, j, s, count);
        dfs(i, j-1, s, count);
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            board = new String[5][5];
            set = new HashSet<>();

            for (int i = 0; i < 5; ++i) {
                board[i] = br.readLine().split(" ");
            }

            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    dfs(i, j, "",0);
                }
            }

            System.out.println(set.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Main().solve();
    }
}