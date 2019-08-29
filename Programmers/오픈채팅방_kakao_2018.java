import java.util.ArrayList;
import java.util.HashMap;

public class Program {
	public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        
        HashMap<String, String> map = new HashMap<>();
        
        for (String s : record) {
        	String[] temp = s.split(" ");
        	
        	if (temp[0].equals("Enter") || temp[0].equals("Change")) {
        		map.put(temp[1], temp[2]);
        	}
        }
        
        for (int i = 0; i < record.length; ++i) {
        	String[] temp = record[i].split(" ");
        	
        	if (temp[0].equals("Enter")) {
        		list.add(map.get(temp[1]) + "님이 들어왔습니다.");
        	} else if (temp[0].equals("Leave")) {
        		list.add(map.get(temp[1]) + "님이 나갔습니다.");
        	}
        }
        
        answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); ++i) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] record = {
				"Enter uid1234 Muzi", 
				"Enter uid4567 Prodo",
				"Leave uid1234",
				"Enter uid1234 Prodo",
				"Change uid4567 Ryan"};
		Program p = new Program();
		
		for (String s : p.solution(record)) {
			System.out.println(s);
		}
	}
}
