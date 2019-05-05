import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;
    int count;
    int direction;

    Node(int y, int x, int count, int direction) {
        this.y = y;
        this.x = x;
        this.count = count;
        this.direction = direction;
    }
}

public class Main {
    int[][] count;
    char[][] arr;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int row, col;
    Node[] c;

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            row = Integer.parseInt(s[1]);
            col = Integer.parseInt(s[0]);
            arr = new char[row][col];
            count = new int[row][col];
            String temp;

            for (int i = 0; i < row; ++i) {
                Arrays.fill(count[i], 2100000000);
            }

            // c[0]: 시작, c[1]: 끝
            c = new Node[2];

            int cIndex = 0;
            for (int i = 0; i < row; ++i) {
                temp = br.readLine();

                for (int j = 0; j < col; ++j) {
                    arr[i][j] = temp.charAt(j);
                    if (arr[i][j] == 'C') {
                        c[cIndex++] = new Node(i, j, 0, -1);
                    }
                }
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(c[0]);
            count[c[0].y][c[0].x] = 0;

            while (!queue.isEmpty()) {
                Node n = queue.poll();

                for (int i = 0; i < 4; ++i) {
                    int x = n.x + directions[i][1];
                    int y = n.y + directions[i][0];

                    if (x >= 0 && y >= 0 && x < col && y < row && arr[y][x] != '*') {
                        if (n.direction == -1) {
                            count[y][x] = n.count;
                            queue.offer(new Node(y, x, n.count, i));
                        } else if (n.direction == i) {
                            if (count[y][x] >= n.count) {
                                count[y][x] = n.count;
                                queue.offer(new Node(y, x, n.count, i));
                            }
                        } else {
                            if (count[y][x] >= n.count + 1) {
                                count[y][x] = n.count + 1;
                                queue.offer(new Node(y, x, n.count + 1, i));
                            }
                        }
                    }
                }
            }

            System.out.println(count[c[1].y][c[1].x]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}