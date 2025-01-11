package binarysearch;

import utilities.PrintData;

public class FindIndxOfRepeatedNum1MethodDoesAll {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9,12, 12, 12};
        int target = 12;
        PrintData.printArray(findBothBoundsOneMethod(nums, target));
    }

    private static int[] findBothBoundsOneMethod(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lowerBound = -1;
        int upperBound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                lowerBound = mid;
                right = mid -1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        left=0;
        right=nums.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                upperBound = mid;
                left = mid+1;
            }
            if (nums[mid] <= target) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return new int[]{lowerBound, upperBound};
    }
}
