import java.io.*;
import java.util.Arrays;
class Ant {
    int number;
    int position;
    int direction;

    Ant(int number, int position, int direction) {
        this.number = number;
        this.position = position;
        this.direction = direction;
    }
}

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int L = Integer.parseInt(s[1]);

            Ant[] ants = new Ant[N + 1];

            int t = 0;
            int l = 0;
            int index = 1;
            for (int n = 1; n <= N; ++n) {
                int x = Integer.parseInt(br.readLine());
                int direction = x > 0 ? 1 : -1;
                ants[n] = new Ant(n, Math.abs(x), direction);

                if (x > 0) {
                    if (t < L - x) {
                        t = L - x;
                        index = n;
                    }
                } else {
                    if (t < 0 - x) {
                        t = 0 - x;
                        index = n;
                    }
                }
            }

            Arrays.sort(ants, 1, N + 1, (o1, o2) -> {
                if (o1.position > o2.position) {
                    return 1;
                } else {
                    return -1;
                }
            });

            for (int i = 1; i <= N; ++i) {
                if (ants[i].number == index) {
                    index = i;
                    break;
                }
            }

            int count = 0;
            if (ants[index].direction == 1) {
                for (int i = index; i <= N; ++i) {
                    if (ants[i].direction == -1) {
                        count++;
                    }
                }
                l = ants[index + count].number;
            } else {
                for (int i = index; i > 0; --i) {
                    if (ants[i].direction == 1) {
                        count++;
                    }
                }
                l = ants[index - count].number;
            }

            System.out.println(l + " " + t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Main().solve();
    }
}