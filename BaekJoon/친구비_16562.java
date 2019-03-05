import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] temps = s.split(" ");

        int N = Integer.parseInt(temps[0]);
        int M = Integer.parseInt(temps[1]);
        int k = Integer.parseInt(temps[2]);

        parent = new int[N + 1];
        costs = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; ++i) {
            costs[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 1; i <= M; ++i) {
            String tmp = br.readLine();
            String[] tmps = tmp.split(" ");

            union(Integer.parseInt(tmps[0]), Integer.parseInt(tmps[1]));
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; ++i) {
            if (!map.containsKey(parent[find(i)])) {
                map.put(parent[find(i)], costs[i]);
            } else {
                map.put(parent[find(i)], Math.min(map.get(parent[find(i)]), costs[i]));
            }
        }

        int result = 0;
        for (Integer i : map.keySet()) {
            result += map.get(i);
        }

        if (result <= k) {
            System.out.println(result);
        } else {
            System.out.println("Oh no");
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