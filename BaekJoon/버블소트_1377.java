import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Node {
    int value;
    int index;

    Node (int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node[] arr = new Node[500001];

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; ++i) {
            arr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr, 1, N + 1, (n1, n2) -> {
            if (n1.value > n2.value) {
                return 1;
            } else if (n1.value == n2.value) {
                return 0;
            }
            return -1;
        });

        int max = arr[1].index - 1;
        for (int i = 2; i <= N; ++i) {
            max = Math.max(max, arr[i].index - i);
        }

        System.out.println(max + 1);
    }
}