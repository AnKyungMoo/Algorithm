import java.io.*;
import java.util.ArrayList;

public class Main {
    int[] arr;
    // -1: 쓰레기, 0: 탐방 안한거, 1: 사이클
    int[] cycle;
    ArrayList<Integer> list;
    boolean[] visit;

    private void dfs(int curr) {
        if (cycle[curr] != 0) {
            for (Integer i : list) {
                cycle[i] = -1;
            }
            return;
        }

        if (visit[curr]) {
            // 사이클 앞에 있는 애들 -1
            int index = list.indexOf(curr);
            for (int i = 0; i < index; ++i) {
                cycle[list.get(i)] = -1;
                visit[list.get(i)] = false;
            }
            // 사이클인 애들끼리 1
            int size = list.size();
            for (int i = index; i < size; ++i) {
                cycle[list.get(i)] = 1;
                visit[list.get(i)] = false;
            }
            return;
        }

        visit[curr] = true;
        list.add(curr);

        dfs(arr[curr]);
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int T = Integer.parseInt(br.readLine());

            String[] s;
            StringBuilder sb = new StringBuilder();
            for (int t = 1; t <= T; ++t) {
                int N = Integer.parseInt(br.readLine());

                arr = new int[N + 1];
                cycle = new int[N + 1];
                list = new ArrayList<>();
                visit = new boolean[N + 1];

                s = br.readLine().split(" ");
                for (int i = 1; i <= N; ++i) {
                    arr[i] = Integer.parseInt(s[i-1]);
                }

                int result = 0;
                for (int i = 1; i <= N; ++i) {
                    list.clear();
                    visit[i] = true;
                    list.add(i);

                    if (cycle[i] == 0) {
                        dfs(arr[i]);
                    }

                    if (cycle[i] == -1) {
                        result++;
                    }
                }

                sb.append(result).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}