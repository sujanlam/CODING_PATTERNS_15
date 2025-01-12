package binarysearch;

public class FindNumInSortedArray {
    public static void main(String[] args) {
        int[] nums = {6, 7, 0, 1, 2, 4, 5};
        int target = 4;
        System.out.println("Target's index is: " + findNumFromSortedArray(nums, target));
    }

    public static int findNumFromSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            //If the mid is the target, return it
            if (nums[mid] == target) {
                return mid;
            }
            //Let's look left sorted portion left or right to locate where mid is.
            //If number at mid is greater than number at left, it's left or its right

            //Sorted portion at left
            if (nums[mid] >= nums[left]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //It's a right sorted portion
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }

        return -1;
    }
}
