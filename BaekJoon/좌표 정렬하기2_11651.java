import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Point implements Comparable<Point>{
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.y > p.y) {
            return 1;
        } else if (this.y == p.y) {
            if (this.x > p.x) {
                return 1;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Point> arrayList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            String insert = br.readLine();
            String[] s = insert.split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            arrayList.add(new Point(x, y));
        }

        Collections.sort(arrayList);

        for (Point point : arrayList) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
