import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10000001];
        int[] indexs = new int[10001];
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
            indexs[arr[i]]++;
        }

        for (int i = 1; i <= 10000; ++i) {
            while (indexs[i] > 0) {
                sb.append(i).append("\n");
                indexs[i]--;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}