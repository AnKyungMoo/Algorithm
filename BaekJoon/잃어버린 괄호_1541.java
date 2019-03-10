import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean minusFlag = false;
        int result = 0;

        String s = br.readLine();
        int index = 0;

        StringBuilder sb = new StringBuilder();
        while (s.length() > index) {
            if (s.charAt(index) == '-' || s.charAt(index) == '+') {
                if (minusFlag) {
                    result -= Integer.parseInt(sb.toString());
                } else {
                    result += Integer.parseInt(sb.toString());
                }

                sb = new StringBuilder();

                if (s.charAt(index) == '-' && !minusFlag) {
                    minusFlag = true;
                }

            } else {
                sb.append(s.charAt(index));
            }

            index++;
        }

        if (minusFlag) {
            result -= Integer.parseInt(sb.toString());
        } else {
            result += Integer.parseInt(sb.toString());
        }

        System.out.println(result);
    }
}