package binarysearch;

import utilities.PrintData;

public class FindTargetIndexDiffIdea {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 12, 12};
        int target = 12;
        PrintData.printArray(findIndexOfTarget(nums, target));
    }

    public static int[] findIndexOfTarget(int[] nums, int target) {
        int fist = lowerBound(nums, target);
        int last = upperBound(nums, target);
        return new int[]{fist, last};
    }

    private static int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return right >= 0 && nums[right] == target ? right : -1;
    }

    private static int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return left < nums.length && nums[left] == target ? left : -1;
    }
}
