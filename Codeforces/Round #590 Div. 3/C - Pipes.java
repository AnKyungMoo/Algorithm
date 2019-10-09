import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(br.readLine());

            for (int t = 0; t < q; ++t) {
                int n = Integer.parseInt(br.readLine());
                String first = br.readLine();
                String second = br.readLine();

                int positionY = 0;
                int positionX = 0;

                while (positionX < n) {
                    if (positionY == 0) {
                        // 위에꺼
                        if (first.charAt(positionX) == '1' || first.charAt(positionX) == '2') {
                            positionX++;
                        } else {
                            if (second.charAt(positionX) == '1' || second.charAt(positionX) == '2') {
                                break;
                            }
                            positionY = 1;
                            positionX++;
                        }
                    } else {
                        // 아래꺼
                        if (second.charAt(positionX) == '1' || second.charAt(positionX) == '2') {
                            positionX++;
                        } else {
                            if (first.charAt(positionX) == '1' || first.charAt(positionX) == '2') {
                                break;
                            }
                            positionY = 0;
                            positionX++;
                        }
                    }
                }

                if (positionX == n && positionY == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
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