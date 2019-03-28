import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            String[] s = new String[2];
            StringTokenizer st;

            BitSet bitSet = new BitSet(21);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine(), " ");

                int index = 0;

                while (st.hasMoreTokens()) {
                   s[index++] = st.nextToken();
                }

                if (s[0].equals("add")) {
                    bitSet.set(Integer.parseInt(s[1]));
                } else if (s[0].equals("remove")) {
                    bitSet.clear(Integer.parseInt(s[1]));
                } else if (s[0].equals("check")) {
                    if (bitSet.get(Integer.parseInt(s[1]))) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                } else if (s[0].equals("toggle")) {
                    bitSet.flip(Integer.parseInt(s[1]));
                } else if (s[0].equals("all")) {
                    bitSet.set(1, 21);
                } else if (s[0].equals("empty")) {
                    bitSet.clear();
                }
            }

            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
