import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine(), 10);
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return b.compareTo(a);
                }
            });

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; ++i) {
                int x = Integer.parseInt(br.readLine(), 10);

                if (x == 0) {
                    if (pq.isEmpty()) {
                        sb.append("0").append("\n");
                    } else {
                        sb.append(pq.poll()).append("\n");
                    }
                } else {
                    pq.offer(x);
                }
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
