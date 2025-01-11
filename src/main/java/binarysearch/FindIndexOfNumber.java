package binarysearch;

public class FindIndexOfNumber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5};
        int target = 5;
        System.out.println("Target's index is: " + findIndexOfTarget(nums, target));
    }

    public static int findIndexOfTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
