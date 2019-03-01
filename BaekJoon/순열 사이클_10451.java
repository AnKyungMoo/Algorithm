import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> set = new HashSet<>();

            arr = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int index = 0;
            while (st.hasMoreTokens()) {
                arr[++index] = Integer.parseInt(st.nextToken());
            }

            parent = new int[N + 1];

            for (int i = 1; i <= N; ++i) {
                parent[i] = i;
            }

            for (int i = 1; i <= N; ++i) {
                union(arr[i], i);
            }

            for (int i = 1; i <= N; ++i) {
                set.add(find(arr[i]));
            }

            System.out.println(set.size());
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        parent[bRoot] = aRoot;
    }
}