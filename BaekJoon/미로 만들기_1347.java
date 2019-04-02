import java.io.*;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            char[][] arr = new char[102][102];
            String s = br.readLine();
            char[] directions = {'b', 'r', 't', 'l'};

            for (int i = 0; i < 102; ++i) {
                Arrays.fill(arr[i], '#');
            }
            int direction = 0;

            int currI = 50;
            int currJ = 50;
            arr[currI][currJ] = '.';
            int minI = currI;
            int minJ = currJ;
            int maxI = currI;
            int maxJ = currJ;

            for (int i = 0; i < N; ++i) {
                if (s.charAt(i) == 'L') {
                    direction = direction - 1;

                    if (direction == -1) {
                        direction = 3;
                    }
                } else if (s.charAt(i) == 'R') {
                    direction = (direction + 1) % 4;
                } else if (s.charAt(i) == 'F') {
                    if (directions[direction] == 'b') {
                        // 아래로
                        --currI;
                    } else if (directions[direction] == 'r') {
                        ++currJ;
                    } else if (directions[direction] == 't') {
                        ++currI;
                    } else if (directions[direction] == 'l') {
                        --currJ;
                    }

                    minI = Math.min(minI, currI);
                    minJ = Math.min(minJ, currJ);
                    maxI = Math.max(maxI, currI);
                    maxJ = Math.max(maxJ, currJ);

                    arr[currI][currJ] = '.';
                }
            }

            for (int i = maxI; i >= minI; --i) {
                for (int j = maxJ; j >= minJ; --j) {
                    System.out.print(arr[i][j]);
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