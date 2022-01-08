

public class Main {
    public int countBalls(int lowLimit, int highLimit) {
        int[] boxs = new int[100];
        int maxCount = 0;

        for (int i = lowLimit; i <= highLimit; ++i) {
            String s = String.valueOf(i);
            int temp = 0;
            for (int j = 0; j < s.length(); ++j) {
                temp += s.charAt(j) - '0';
            }
            boxs[temp]++;

            maxCount = Math.max(maxCount, boxs[temp]);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(new Main().countBalls(5, 15));
    }
}