import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");

            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                if (!arrayList.contains(Integer.parseInt(s[i]))) {
                    if (arrayList.size() < k) {
                        arrayList.add(Integer.parseInt(s[i]));
                    } else {
                        arrayList.remove(0);
                        arrayList.add(Integer.parseInt(s[i]));
                    }
                }
            }

            Collections.reverse(arrayList);
            System.out.println(arrayList.size());
            for (int i = 0; i < arrayList.size(); ++i) {
                System.out.print(arrayList.get(i) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}