import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            int[][] arr1 = new int[n][m];
            int[][] arr2 = new int[n][m];

            String[] temp;
            for (int i = 0; i < n; ++i) {
                temp = br.readLine().split(" ");

                for (int j = 0; j < m; ++j) {
                    arr1[i][j] = Integer.parseInt(temp[j]);
                }
            }

            for (int i = 0; i < n; ++i) {
                temp = br.readLine().split(" ");

                for (int j = 0; j < m; ++j) {
                    arr2[i][j] = Integer.parseInt(temp[j]);

                    if (arr1[i][j] < arr2[i][j]) {
                        int tmp = arr1[i][j];
                        arr1[i][j] = arr2[i][j];
                        arr2[i][j] = tmp;
                    }
                }
            }

            boolean isPossible = true;

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m - 1; ++j) {
                    if (arr1[i][j] >= arr1[i][j + 1]) {
                        isPossible = false;
                        i = n;
                        break;
                    }

                    if (arr2[i][j] >= arr2[i][j + 1]) {
                        isPossible = false;
                        i = n;
                        break;
                    }
                }
            }

            for (int i = 0; i < n - 1; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (arr1[i][j] >= arr1[i + 1][j]) {
                        isPossible = false;
                        i = n;
                        break;
                    }

                    if (arr2[i][j] >= arr2[i + 1][j]) {
                        isPossible = false;
                        i = n;
                        break;
                    }
                }
            }

            if (isPossible) {
                System.out.println("Possible");
            }
            else {
                System.out.println("Impossible");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
