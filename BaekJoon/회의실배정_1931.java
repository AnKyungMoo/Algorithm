import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Node {
    int start;
    int end;

    Node (int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N];

        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            String[] temps = s.split(" ");

            int start = Integer.parseInt(temps[0]);
            int end = Integer.parseInt(temps[1]);
            nodes[i] = new Node(start, end);
        }

        Arrays.sort(nodes, (n1, n2) -> {
            if (n1.end > n2.end) {
                return 1;
            } else if (n1.end == n2.end) {
                if (n1.start > n2.start) {
                    return 1;
                }
            }
            return -1;
        });

        Node curr = nodes[0];
        int result = 1;
        for (int i = 1; i < N; ++i) {
            if (curr.end <= nodes[i].start) {
                curr = nodes[i];
                result++;
            }
        }

        System.out.println(result);
    }
}
