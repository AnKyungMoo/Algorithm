import java.io.*;
import java.util.Stack;

public class Solution_5432_쇠막대기자르기_안경무 {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        	int T = Integer.parseInt(br.readLine());
        	
        	for (int t = 1; t <= T; ++t) {
        		Stack<Character> stack = new Stack<>();
        		String s = br.readLine();
        		
        		int result = 0;
        		
        		char prev = s.charAt(0);
        		stack.add(s.charAt(0));
        		for (int i = 1; i < s.length(); ++i) {
        			if (s.charAt(i) == ')') {
        				stack.pop();
        				if (prev == ')') {
        					result++;
        				} else {
        					result += stack.size();
        				}
        				prev = ')';
        			} else {
        				stack.push('(');
        				prev = '(';
        			}
        		}
        		
        		System.out.println("#" + t + " " + result);
        	}
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}