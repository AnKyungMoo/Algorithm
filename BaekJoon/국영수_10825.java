import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Node {
    String name;
    int korean;
    int english;
    int math;

    Node (String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node[] nodes = new Node[100001];

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; ++i) {
            String insert = br.readLine();
            String[] s = insert.split(" ");

            nodes[i] = new Node(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
        }

        Arrays.sort(nodes, 1, N + 1, (n1, n2) -> {
            if (n1.korean < n2.korean) {
                return 1;
            } else if (n1.korean == n2.korean) {
                if (n1.english > n2.english) {
                    return 1;
                } else if (n1.english == n2.english) {
                    if (n1.math < n2.math) {
                        return 1;
                    } else if (n1.math == n2.math) {
                        return n1.name.compareTo(n2.name);
                    }
                }
            }
            return -1;
        });

        for (int i = 1; i <= N; ++i) {
            System.out.println(nodes[i].name);
        }
    }
}
