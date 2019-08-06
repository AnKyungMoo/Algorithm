import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int i;
    int j;
    int distance;

    Node(int i, int j, int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}

public class Main {
    int N;
    int M;
    int D;
    int[][] board;
    int[][] map;
    int[][] direct = {{0, -1}, {-1, 0}, {0, 1}};
    boolean[][] isVisit;
    int result;

    private void bfs() {
        for (int n = 0; n <= N; ++n) {
            map[n] = board[n].clone();
        }

        Queue<Node> q = new LinkedList<>();
        int tempResult = 0;

        int cycle = 0;
        while (cycle < N) {
            for (int i = 0; i < N; ++i) {
                Arrays.fill(isVisit[i], false);
            }

            for (int i = 0; i < M; ++i) {
                if (map[N][i] == 2) {
                    q.offer(new Node(N, i, 0));

                    while (!q.isEmpty()) {
                        Node n = q.poll();

                        for (int a = 0; a < 3; ++a) {
                            int newI = n.i + direct[a][0];
                            int newJ = n.j + direct[a][1];

                            if (newI >= 0 && newI < N && newJ >= 0 && newJ < M && n.distance + 1 <= D) {
                                if (map[newI][newJ] == 1 ) {
                                    isVisit[newI][newJ] = true;

                                    q.clear();
                                    break;
                                } else {
                                    q.offer(new Node(newI, newJ, n.distance + 1));
                                }
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (isVisit[i][j]) {
                        tempResult++;
                        map[i][j] = 0;
                    }
                }
            }

            for (int i = N-2; i >= 0; --i) {
                for (int j = M-1; j >= 0; --j) {
                    map[i+1][j] = map[i][j];
                }
            }

            for (int i = 0; i < M; ++i) {
                map[0][i] = 0;
            }

            cycle++;
        }

        result = Math.max(result, tempResult);
    }

    private void dfs(int index, int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = index + 1; i < M; ++i) {
            board[N][i] = 2;
            dfs(i, count + 1);
            board[N][i] = 0;
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            D = Integer.parseInt(s[2]);
            result = 0;

            board = new int[N + 1][M];
            map = new int[N + 1][M];
            isVisit = new boolean[N + 1][M];

            for (int i = 0; i < N; ++i) {
                s = br.readLine().split(" ");
                for (int j = 0; j < M; ++j) {
                    board[i][j] = Integer.parseInt(s[j]);
                }
            }

            for (int i = 0; i < M; ++i) {
                board[N][i] = 2;
                dfs(i, 1);
                board[N][i] = 0;
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