package slidingwondow;

public class MaxOfGivenConsequentIntegers {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1, 2, 1, 1};
        int k = 4;
        System.out.println(maxOfSlidWindow(nums, k));
    }

    public static int maxOfSlidWindow(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        int newSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        System.out.println("Sum: "+sum);
        for (int i = k; i < nums.length; i++) {
            newSum = sum + nums[i] - nums[i-k];
            max = Math.max(max, newSum);
        }

        return max;
    }
}
