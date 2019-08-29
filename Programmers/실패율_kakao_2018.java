import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Program {
	class Node {
		int index;
		double rate;
		
		Node(int index, double rate) {
			this.index = index;
			this.rate = rate;
		}
	}
	
	public int[] solution(int N, int[] stages) {
        int[] answer = {};
        ArrayList<Node> list = new ArrayList<>();
        
        for (int n = 1; n <= N; ++n) {
        	int total = 0;
        	int fail = 0;
        	for (int i = 0; i < stages.length; ++i) {
        		if (stages[i] > n) {
        			total++;
        		} else if (stages[i] == n) {
        			total++;
        			fail++;
        		}
        	}
        	
        	if (fail == 0 && total == 0) {
        		list.add(new Node(n, 0));
        	}
        	list.add(new Node(n, (double)fail / total));
        }
        
        Collections.sort(list, (n1, n2) -> {
        	if (n1.rate < n2.rate) {
        		return 1;
        	} else if (n1.rate == n2.rate) {
        		if (n1.index > n2.index) {
        			return 1;
        		}
        		return 0;
        	}
        	return -1;
        });
        
        
        answer = new int[list.size()];
        for (int i = 0; i < answer.length; ++i) {
        	answer[i] = list.get(i).index;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//		int N = 4;
//		int[] stages = {4, 4, 4, 4, 4};
		
		Program p = new Program();
		
		for (int s : p.solution(N, stages)) {
			System.out.println(s);
		}
	}
}
