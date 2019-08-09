import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());

            ArrayList<String> deckA;
            ArrayList<String> deckB;

            for (int t = 1; t <= T; ++t) {
                sb.append("#").append(t).append(" ");
                int N = Integer.parseInt(br.readLine());

                deckA = new ArrayList<>();
                deckB = new ArrayList<>();

                String[] s = br.readLine().split(" ");

                int mid = N / 2;
                if (N % 2 == 1) {
                    mid++;
                }

                for (int i = 0; i < mid; ++i) {
                    deckA.add(s[i]);
                }

                for (int i = mid; i < N; ++i) {
                    deckB.add(s[i]);
                }

                ArrayList<String> result = new ArrayList<>();
                int indexA = 0;
                int indexB = 0;

                for (int i = 0; i < N; ++i) {
                    if (i % 2 == 0) {
                        result.add(deckA.get(indexA++));
                    } else {
                        result.add(deckB.get(indexB++));
                    }
                }

                for (String temp : result) {
                    sb.append(temp).append(" ");
                }

                sb.append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}