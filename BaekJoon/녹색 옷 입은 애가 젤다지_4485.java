import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    int cost;

    Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class Main {
    static final int INF = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N;
        int[][] arr;
        int[][] dist;
        LinkedList<Node> queue;
        StringBuilder sb = new StringBuilder();
        int index = 1;

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            queue = new LinkedList<>();
            arr = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    dist[i][j] = INF;
                }
            }

            for (int i = 0; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < N; ++j) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist[0][0] = arr[0][0];
            queue.add(new Node(0, 0, dist[0][0]));

            while (!queue.isEmpty()) {
                Node n = queue.poll();

                if (n.x + 1 < N) {
                    if (dist[n.y][n.x + 1] > n.cost + arr[n.y][n.x + 1]) {
                        dist[n.y][n.x + 1] = n.cost + arr[n.y][n.x + 1];
                        queue.add(new Node(n.x + 1, n.y, dist[n.y][n.x + 1]));
                    }
                }

                if (n.x - 1 >= 0) {
                    if (dist[n.y][n.x - 1] > n.cost + arr[n.y][n.x - 1]) {
                        dist[n.y][n.x - 1] = n.cost + arr[n.y][n.x - 1];
                        queue.add(new Node(n.x - 1, n.y, dist[n.y][n.x - 1]));
                    }
                }

                if (n.y + 1 < N) {
                    if (dist[n.y + 1][n.x] > n.cost + arr[n.y + 1][n.x]) {
                        dist[n.y + 1][n.x] = n.cost + arr[n.y + 1][n.x];
                        queue.add(new Node(n.x, n.y + 1, dist[n.y + 1][n.x]));
                    }
                }

                if (n.y - 1 >= 0) {
                    if (dist[n.y - 1][n.x] > n.cost + arr[n.y - 1][n.x]) {
                        dist[n.y - 1][n.x] = n.cost + arr[n.y - 1][n.x];
                        queue.add(new Node(n.x, n.y - 1, dist[n.y - 1][n.x]));
                    }
                }
            }

            sb.append("Problem ").append(index++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
