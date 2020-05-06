import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    String[] s;
    boolean[] visit;
    int size;
    ArrayList<String> arrayList;

    private void dfs(int currIndex) {
        if (arrayList.size() == 6) {
            for (String item : arrayList) {
                System.out.print(item + " ");
            }
            System.out.println();
            return;
        }

        for (int i = currIndex; i < size; ++i) {
            if (!visit[i]) {
                visit[i] = true;
                arrayList.add(s[i]);
                dfs(i + 1);
                visit[i] = false;
                arrayList.remove(s[i]);
            }
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                s = br.readLine().split(" ");

                size = Integer.parseInt(s[0]) + 1;

                if (size == 1) {
                    break;
                }

                visit = new boolean[size];
                arrayList = new ArrayList<>();

                for (int i = 1; i < size; ++i) {
                    visit[i] = true;
                    arrayList.add(s[i]);
                    dfs(i);
                    arrayList.remove(s[i]);
                }

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main().solve();
    }
}