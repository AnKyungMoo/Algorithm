import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Node {
    int age;
    String name;
    int index;

    Node (int age, String name, int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node[] nodes = new Node[100001];

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; ++i) {
            String insert = br.readLine();
            String[] s= insert.split(" ");

            nodes[i] = new Node(Integer.parseInt(s[0]), s[1], i);
        }

        Arrays.sort(nodes, 1, N + 1, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.age > n2.age) {
                    return 1;
                } else if (n1.age == n2.age) {
                    if (n1.index > n2.index) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        for (int i = 1; i <= N; ++i) {
            System.out.println(nodes[i].age + " " + nodes[i].name);
        }
    }
}
