import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();

            String result = "";
            Stack<Character> stack = new Stack<>();
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('*', 2);
            map.put('/', 2);
            map.put('+', 1);
            map.put('-', 1);
            map.put('(', 3);

            for (int i = 0; i < s.length(); ++i) {
                char item = s.charAt(i);

                if (item == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result += stack.pop();
                    }
                    stack.pop();
                } else if (map.containsKey(item)) {
                    if (!stack.isEmpty() && map.get(stack.peek()) >= map.get(item)) {
                        while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(item)
                        && stack.peek() != '(') {
                            result += stack.pop();
                        }
                    }

                    stack.push(item);
                } else {
                    result += item;
                }
            }
            while (!stack.isEmpty()) {
                result += stack.pop();
            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}