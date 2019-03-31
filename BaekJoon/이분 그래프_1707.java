import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int K = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] graph;
            int[] colors;
            boolean[] visits;
            Stack<Integer> stack;

            for (int k = 1; k <= K; ++k) {
                stack = new Stack<>();
                String[] s = br.readLine().split(" ");
                int V = Integer.parseInt(s[0]);
                int E = Integer.parseInt(s[1]);

                graph = new ArrayList[V + 1];
                colors = new int[V + 1];
                visits = new boolean[V + 1];

                for (int i = 1; i <= V; ++i) {
                    graph[i] = new ArrayList<>();
                }

                for (int e = 1; e <= E; ++e) {
                    s = br.readLine().split(" ");
                    int a = Integer.parseInt(s[0]);
                    int b = Integer.parseInt(s[1]);

                    graph[a].add(b);
                    graph[b].add(a);
                }

                boolean isCheck = false;
                for (int start = 1; start <= V; ++start) {
                    if (colors[start] == 0) {
                        colors[start] = 1;
                    }
                    visits[start] = true;

                    stack.push(start);

                    // 색 채우기
                    while (!stack.isEmpty()) {
                        int curr = stack.pop();

                        for (int i : graph[curr]) {
                            if (visits[i]) {
                                // 색깔 체크
                                if (colors[i] == colors[curr]) {
                                    isCheck = true;
                                    break;
                                }
                            } else {
                                stack.push(i);
                                visits[i] = true;
                                colors[i] = colors[curr] == 1 ? 2 : 1;
                            }
                        }

                        if (isCheck) {
                            start = V;
                            break;
                        }
                    }
                }


                // 출력
                if (isCheck) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}