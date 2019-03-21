class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] count = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            count[i] = 1;
        }

        for (int i = 0; i < lost.length; ++i) {
            count[lost[i]]--;
        }

        for (int i = 0; i < reserve.length; ++i) {
            count[reserve[i]]++;
        }

        for (int i = 1; i <= n ; ++i) {
            if (i > 1 && count[i] == 0 && count[i-1] >= 2) {
                count[i]++;
                count[i-1]--;
            } else if (i < n && count[i] == 0 && count[i+1] >= 2) {
                count[i]++;
                count[i+1]--;
            }
        }

        for (int i = 1; i <= n; ++i) {
            if (count[i] != 0) {
                answer++;
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] lost = {3, 4};
        int[] reserve = {4, 5};
        System.out.println(new Solution().solution(5, lost, reserve));
    }
}
