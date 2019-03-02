import java.io.*;
import java.util.LinkedList;

class Node {
    int x;
    int y;
    int count;

    Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Node> queue = new LinkedList<>();

        String s = br.readLine();
        String[] temp = s.split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        board = new int[N + 2][M + 2];

        for (int i = 1; i <= N; ++i) {
            String value = br.readLine();

            for (int j = 1; j <= M; ++j) {
                board[i][j] = value.charAt(j - 1) - '0';
            }
        }

        queue.addLast(new Node(1, 1, 0));

        while (!queue.isEmpty()) {
            Node n = queue.pop();

            if (board[n.y][n.x] == 1) {
                board[n.y][n.x] = n.count + 1;

                if (n.y == N && n.x == M) {
                    System.out.println(board[n.y][n.x]);
                    break;
                }

                queue.addLast(new Node(n.x + 1, n.y, board[n.y][n.x]));
                queue.addLast(new Node(n.x - 1, n.y, board[n.y][n.x]));
                queue.addLast(new Node(n.x, n.y - 1, board[n.y][n.x]));
                queue.addLast(new Node(n.x, n.y + 1, board[n.y][n.x]));
            }
        }
    }
}
