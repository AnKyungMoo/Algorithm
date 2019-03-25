import java.io.*;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            Stack<Integer> st = new Stack<>();

            StringBuilder sb = new StringBuilder();
            int x;
            int number = 1;
            int count = 0;
            while (count < n) {
                x = Integer.parseInt(br.readLine());
                count++;

                while (number <= x) {
                    st.push(number++);
                    sb.append("+\n");

                    while (st.peek().equals(x)) {
                        st.pop();
                        sb.append("-\n");

                        if (count >= n) {
                            break;
                        }

                        x = Integer.parseInt(br.readLine());
                        count++;

                        if (st.isEmpty()) {
                            break;
                        }
                    }
                }
            }

            if (st.size() > 0) {
                sb = new StringBuilder();
                sb.append("NO");
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