import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");

            Deque<Integer> deque = new LinkedList<>();
            HashMap<Integer, Boolean> map = new HashMap<>();

            for (int i = 0; i < n; ++i) {
                int num = Integer.parseInt(s[i]);
                if (!map.containsKey(num)) {
                    if (deque.size() < k) {
                        deque.add(num);
                        map.put(num, true);
                    } else {
                        map.put(deque.getFirst(), false);
                        deque.removeFirst();
                        map.put(num, true);
                        deque.addLast(num);
                    }
                } else {
                    if (!map.get(num)) {
                        if (deque.size() < k) {
                            deque.addLast(num);
                            map.put(num, true);
                        } else {
                            map.put(deque.getFirst(), false);
                            deque.removeFirst();
                            map.put(num, true);
                            deque.add(num);
                        }
                    }
                }
            }

            int size = deque.size();
            System.out.println(size);
            while (!deque.isEmpty()) {
                System.out.print(deque.getLast() + " ");
                deque.removeLast();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}