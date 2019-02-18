import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b;
        String s;
        int m;
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        s = br.readLine();

        String[] x = s.split(" ");

        a = Integer.parseInt(x[0]);
        b = Integer.parseInt(x[1]);

        m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int index = 0;
        while (st.hasMoreTokens()) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        while (!stack.empty()) {
            result += stack.pop() * Math.pow(a, index++);
        }

        while (result / b != 0) {
            stack.push(result % b);
            result /= b;
        }

        System.out.print(result);
        while (!stack.empty()) {
            System.out.print(" " + stack.pop());
        }
    }
}
