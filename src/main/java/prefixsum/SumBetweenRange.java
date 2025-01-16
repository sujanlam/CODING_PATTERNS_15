package prefixsum;

public class SumBetweenRange {
    public static void main(String[] args) {
        int[] nums = {3,-7,6,0,-2,5};
        System.out.println(sumBetnRange(nums, 2,2));
    }

    private static int sumBetnRange(int[] nums, int m, int n) {
        int sum = 0;
        for (int i = m; i <= n; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
