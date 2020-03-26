import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            String[] s;
            for (int t = 0; t < T; ++t) {
                HashMap<Integer, Integer> map = new HashMap<>();

                int n = Integer.parseInt(br.readLine());
                int princess = 0;

                for (int i = 1; i <= n; ++i) {
                    s = br.readLine().split(" ");

                    int a = Integer.parseInt(s[0]);

                    boolean isFind = false;

                    for (int x = 1; x <= a; ++x) {
                        int key = Integer.parseInt(s[x]);
                        if (!map.containsKey(key)) {
                            map.put(key, i);
                            isFind = true;
                            break;
                        }
                    }

                    if (!isFind) {
                        princess = i;
                    }
                }

                if (princess == 0) {
                    System.out.println("OPTIMAL");
                } else {
                    for (int i = 1; i <= n; ++i) {
                        if (!map.containsKey(i)) {
                            System.out.println("IMPROVE");
                            System.out.println(princess + " " + i);
                            break;
                        }
                    }
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