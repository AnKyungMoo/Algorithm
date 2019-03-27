import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    int depth;

    Node(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }
}

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int T = Integer.parseInt(br.readLine());
            String[] s;

            ArrayList<Integer> primes = new ArrayList<>();
            boolean[] arr = new boolean[10000];

            arr[0] = arr[1] = true;
            for (int i = 0; i <= 9999; ++i) {
                if (!arr[i]) {
                    if (i >= 1000) {
                        primes.add(i);
                    }
                    for (int j = i * i; j <= 9999; j += i) {
                        arr[j] = true;
                    }
                }
            }

            Queue<Node> queue;
            boolean[] visits = new boolean[10000];

            StringBuilder sb = new StringBuilder();

            for (int t = 0; t < T; ++t) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                Arrays.fill(visits, false);

                queue = new LinkedList<>();

                queue.offer(new Node(start, 0));
                visits[start] = true;
                int depth = -1;
                while (!queue.isEmpty()) {
                    Node curr = queue.poll();

                    if (curr.value == end) {
                        depth = curr.depth;
                        break;
                    }

                    int one = (curr.value / 10) * 10;
                    for (int i = 0; i < 10; ++i) {
                        if (!visits[one + i]) {
                            if (primes.contains(one + i)) {
                                queue.offer(new Node(one + i, curr.depth + 1));
                                visits[one + i] = true;
                            }
                        }
                    }

                    int two = (curr.value / 100) * 100 + (curr.value % 10);
                    for (int i = 0; i < 100; i += 10) {
                        if (!visits[two + i]) {
                            if (primes.contains(two + i)) {
                                queue.offer(new Node(two + i, curr.depth + 1));
                                visits[two + i] = true;
                            }
                        }
                    }

                    int three = (curr.value / 1000) * 1000 + (curr.value % 100);
                    for (int i = 0; i < 1000; i += 100) {
                        if (!visits[three + i]) {
                            if (primes.contains(three + i)) {
                                queue.offer(new Node(three + i, curr.depth + 1));
                                visits[three + i] = true;
                            }
                        }
                    }

                    int four = curr.value % 1000;
                    for (int i = 0; i < 10000; i += 1000) {
                        if (!visits[four + i]) {
                            if (primes.contains(four + i)) {
                                queue.offer(new Node(four + i, curr.depth + 1));
                                visits[four + i] = true;
                            }
                        }
                    }
                }

                if (depth == -1) {
                    sb.append("Impossible\n");
                } else {
                    sb.append(depth).append("\n");
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
