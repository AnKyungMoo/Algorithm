import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    class Obj {
        int index;
        int cost;

        Obj(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] arr = new int[n];

            for (int i = 0; i < n; ++i) {
                arr[i] = Integer.parseInt(s[i]);
            }

            ArrayList<Obj> list = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                list.add(new Obj(i + 1, arr[i]));
            }

            Collections.sort(list, (n1, n2) -> n1.cost < n2.cost ? 1 : -1);
            Obj o = list.get(0);
            list.remove(o);
            list.add(o);

            int result = 1;
            for (int i = 0; i < n - 1; ++i) {
                result += (list.get(i).cost * (i + 1)) + 1;
            }

            Collections.sort(list, (n1, n2) -> n1.cost < n2.cost ? 1 : -1);

            System.out.println(result);
            for (int i = 0; i < list.size(); ++i) {
                System.out.print(list.get(i).index + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}