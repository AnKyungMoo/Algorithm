import java.io.*;
import java.util.HashMap;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            HashMap<String, Integer> nameToNumberMap = new HashMap<>();
            HashMap<Integer, String> numberToNameMap = new HashMap<>();

            String s = br.readLine();
            String[] temp = s.split(" ");

            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);

            for (int i = 1; i <= N; ++i) {
                String input = br.readLine();
                nameToNumberMap.put(input, i);
                numberToNameMap.put(i, input);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= M; ++i) {
                String input = br.readLine();

                if (input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') {
                    sb.append(nameToNumberMap.get(input)).append("\n");
                } else {
                    sb.append(numberToNameMap.get(Integer.parseInt(input))).append("\n");
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
