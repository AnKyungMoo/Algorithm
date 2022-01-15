public class Solution {
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        int result = 0;

        for (int num : nums) {
            arr[num]++;
        }

        for (int i = 0; i < 101; ++i) {
            if (arr[i] == 1) result += i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        System.out.println(new Solution().sumOfUnique(nums));
    }
}
