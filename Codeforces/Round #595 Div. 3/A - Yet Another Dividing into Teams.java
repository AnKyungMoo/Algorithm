import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; ++t) {
                int n = Integer.parseInt(br.readLine());
                int[] arr = new int[n];
                String[] s = br.readLine().split(" ");

                for (int i = 0; i < n; ++i) {
                    arr[i] = Integer.parseInt(s[i]);
                }

                Arrays.sort(arr);

                boolean flag = true;
                int team = 0;
                while (flag) {
                    int curr = -1;
                    flag = false;

                    for (int i = 0; i < n; ++i) {
                        if (arr[i] != 0) {
                            curr = arr[i];
                            break;
                        }
                    }

                    for (int i = 0; i < n; ++i) {
                        if (arr[i] == 0) {
                            continue;
                        }

                        if (Math.abs(arr[i] - curr) == 1) {
                            continue;
                        }

                        curr = arr[i];
                        arr[i] = 0;
                        flag = true;
                    }

                    if (!flag) {
                        break;
                    }

                    team++;
                }

                System.out.println(team);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}