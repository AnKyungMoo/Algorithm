import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] strings = s.split(" ");

        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);
        int V = Integer.parseInt(strings[2]);

        ArrayList<Integer>[] arrayList = new ArrayList[N + 1];

        for (int i = 1; i <= N; ++i) {
            arrayList[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= M; ++i) {
            String temp = br.readLine();
            String[] temps = temp.split(" ");

            int p1 = Integer.parseInt(temps[0]);
            int p2 = Integer.parseInt(temps[1]);

            arrayList[p1].add(p2);
            arrayList[p2].add(p1);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] isVisitStack = new boolean[N + 1];

        StringBuilder sb = new StringBuilder();

        stack.push(V);

        while (!stack.empty()) {
            int curr = stack.pop();

            if (!isVisitStack[curr]) {
                isVisitStack[curr] = true;
                sb.append(curr).append(" ");

                ArrayList<Integer> list = new ArrayList<>();

                for (int i = 0; i < arrayList[curr].size(); ++i) {
                    if (!isVisitStack[arrayList[curr].get(i)]) {
                        list.add(arrayList[curr].get(i));
                    }
                }

                Collections.sort(list);

                for (int i = list.size() - 1; i >= 0; --i) {
                    stack.push(list.get(i));
                }
            }
        }

        sb.append("\n");

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] isVisitQueue = new boolean[N + 1];

        queue.add(V);

        while (!queue.isEmpty()) {
            int curr = queue.pop();

            if (!isVisitQueue[curr]) {
                isVisitQueue[curr] = true;
                sb.append(curr).append(" ");

                ArrayList<Integer> list = new ArrayList<>();

                for (int i = 0; i < arrayList[curr].size(); ++i) {
                    if (!isVisitQueue[arrayList[curr].get(i)]) {
                        list.add(arrayList[curr].get(i));
                    }
                }

                Collections.sort(list);

                for (int i = 0; i < list.size(); ++i) {
                    queue.add(list.get(i));
                }
            }
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}