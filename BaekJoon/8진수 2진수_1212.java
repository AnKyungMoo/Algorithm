import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String s;
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();

        for (int i = 0; i < s.length(); ++i) {
            int a = s.charAt(i) - '0';
            StringBuilder temp_result = new StringBuilder();
            int temp = 0;

            while (a / 2 != 0) {
                temp = a % 2;
                a /= 2;

                temp_result.insert(0, temp);
            }

            temp_result.insert(0, a);

            while (temp_result.length() < 3) {
                temp_result.insert(0, 0);
            }

            result.append(temp_result);
        }

        while (result.length() != 1 && result.charAt(0) == '0') {
            result = new StringBuilder(result.toString().replaceFirst("0", ""));
        }
        System.out.println(result);
    }
}
