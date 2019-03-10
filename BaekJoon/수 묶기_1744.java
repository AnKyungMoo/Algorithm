import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> positiveArray = new ArrayList<>();
        ArrayList<Integer> negativeArray = new ArrayList<>();


        for (int i = 0; i < N; ++i) {
            int n = Integer.parseInt(br.readLine());

            if (n > 0) {
                positiveArray.add(n);
            } else {
                negativeArray.add(n);
            }
        }

        Collections.sort(positiveArray, Collections.reverseOrder());
        Collections.sort(negativeArray);

        int result = 0;

        // 양수
        int positiveSize = positiveArray.size();
        for (int i = 0; i < positiveSize; i += 2) {
            if (i + 1 < positiveSize) {
                if (positiveArray.get(i) > 1 && positiveArray.get(i + 1) > 1) {
                    result += positiveArray.get(i) * positiveArray.get(i + 1);
                } else {
                    result += positiveArray.get(i) + positiveArray.get(i + 1);
                }
            } else {
                result += positiveArray.get(i);
            }
        }

        // 음수
        int negativeSize = negativeArray.size();
        for (int i = 0; i < negativeSize; i += 2) {
            if (i + 1 < negativeSize) {
                result += negativeArray.get(i) * negativeArray.get(i + 1);
            } else {
                result += negativeArray.get(i);
            }
        }

        System.out.println(result);
    }
}