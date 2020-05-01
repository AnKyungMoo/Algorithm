import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    class Node {
        int num;
        int count;

        Node (int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            boolean[] visit = new boolean[100010];

            int N = Integer.parseInt(s[0]);
            int K = Integer.parseInt(s[1]);

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(N, 0));
            visit[N] = true;

            while (!queue.isEmpty()) {
                Node curr = queue.poll();

                if (curr.num == K) {
                    System.out.println(curr.count);
                    break;
                }

                if (((curr.num + 1) <= 100000) && !visit[curr.num + 1]) {
                    visit[curr.num + 1] = true;
                    queue.add(new Node(curr.num + 1, curr.count + 1));
                }

                if (((curr.num - 1) >= 0) && !visit[curr.num - 1]) {
                    visit[curr.num - 1] = true;
                    queue.add(new Node(curr.num - 1, curr.count + 1));
                }

                if (((curr.num * 2) <= 100000) && !visit[curr.num * 2]) {
                    visit[curr.num * 2] = true;
                    queue.add(new Node(curr.num * 2, curr.count + 1));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().solve();
    }
}