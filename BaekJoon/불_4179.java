import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;
    int count;
    boolean isFire;

    Node(int y, int x, int count, boolean isFire) {
        this.y = y;
        this.x = x;
        this.count = count;
        this.isFire = isFire;
    }
}

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int R = Integer.parseInt(s[0]);
            int C = Integer.parseInt(s[1]);

            char[][] arr = new char[R][C];
            boolean[][] visit = new boolean[1001][1001];

            String temp;
            int jihoonX = 0, jihoonY = 0;

            Queue<Node> queue = new LinkedList<>();
            for (int i = 0; i < R; ++i) {
                temp = br.readLine();

                for (int j = 0; j < C; ++j) {
                    arr[i][j] = temp.charAt(j);

                    if (arr[i][j] == 'J') {
                        jihoonX = j;
                        jihoonY = i;
                    } else if (arr[i][j] == 'F') {
                        queue.offer(new Node(i, j, 1, true));
                    }
                }
            }


            queue.offer(new Node(jihoonY, jihoonX, 1, false));
            visit[jihoonY][jihoonX] = true;

            boolean isCheck = false;
            int result = -1;
            int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int y, x;
            while (!queue.isEmpty()) {
                Node n = queue.poll();

                if (n.isFire) {
                    // 불일 때
                    for (int i = 0; i < 4; ++i) {
                        x = n.x + direction[i][1];
                        y = n.y + direction[i][0];

                        if (x >= 0 && x < C && y >= 0 && y < R) {
                            if (arr[y][x] != '#' && arr[y][x] != 'F') {
                                arr[y][x] = 'F';
                                queue.offer(new Node(y, x, n.count + 1, true));
                            }
                        }
                    }
                } else {
                    // 지훈이 일 때
                    for (int i = 0; i < 4; ++i) {
                        x = n.x + direction[i][1];
                        y = n.y + direction[i][0];

                        if (x < 0 || y < 0 || x >= C || y >= R) {
                            isCheck = true;
                            result = n.count;
                            break;
                        }

                        if (arr[y][x] != '#' && arr[y][x] != 'F' && !visit[y][x]) {
                            queue.offer(new Node(y, x, n.count + 1, false));
                            visit[y][x] = true;
                        }
                    }

                    if (isCheck) {
                        break;
                    }
                }
            }

            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}