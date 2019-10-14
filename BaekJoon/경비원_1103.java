import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	class Node {
		int y;
		int x;
		
		Node (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	private void solve() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] s = br.readLine().split(" ");
			
			int garo = Integer.parseInt(s[0]);
			int sero = Integer.parseInt(s[1]);
			
			int q = Integer.parseInt(br.readLine());
			
			ArrayList<Node> arrayList = new ArrayList<>();
			for (int i = 0; i < q; ++i) {
				s = br.readLine().split(" ");
				
				int flag = Integer.parseInt(s[0]);
				int distance = Integer.parseInt(s[1]);
				
				switch (flag) {
				case 1:
					arrayList.add(new Node(0, distance));
					break;
				case 2:
					arrayList.add(new Node(sero, distance));
					break;
				case 3:
					arrayList.add(new Node(distance, 0));
					break;
				case 4:
					arrayList.add(new Node(distance, garo));
					break;
				default:
					break;
				}
			}
			
			s = br.readLine().split(" ");
			int flagDG = Integer.parseInt(s[0]);
			int distanceDG = Integer.parseInt(s[1]);
			
			int startY = 0;
			int startX = 0;
			switch (flagDG) {
			case 1:
				startY = 0;
				startX = distanceDG;
				break;
			case 2:
				startY = sero;
				startX = distanceDG;
				break;
			case 3:
				startY = distanceDG;
				startX = 0;
				break;
			case 4:
				startY = distanceDG;
				startX = garo;
				break;
			}
			
			int result = 0;
			for (Node n : arrayList) {
				if (n.y != startY) {
					int temp1 = startX + n.x + Math.abs(startY - n.y);
					int temp2 = Math.abs(garo - startX) + 
							Math.abs(garo - n.x) + 
							Math.abs(startY - n.y);
					
					result += Math.min(temp1, temp2);
				} else {
					result += Math.abs(startX - n.x);
				}
			}
			
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
