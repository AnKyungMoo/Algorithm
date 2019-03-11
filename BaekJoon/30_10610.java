import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> arrayList = new ArrayList<>();

        String N = br.readLine();

        int sum = 0;

        for (int i = 0; i < N.length(); ++i) {
            sum += N.charAt(i) - '0';
            arrayList.add(N.charAt(i) - '0');
        }

        Collections.sort(arrayList, Collections.reverseOrder());

        int size = arrayList.size();
        StringBuilder sb = new StringBuilder();
        if (sum % 3 == 0 && arrayList.get(size - 1) == 0) {
            for (Integer integer : arrayList) {
                sb.append(integer);
            }
        } else {
            sb.append("-1");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
