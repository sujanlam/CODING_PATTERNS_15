package twopointers;

import utilities.PrintData;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int[] arr2 = {1, 0, 1};
        int[] resArr = shiftZerosTotEndOptimizedAgain(arr2);
        PrintData.printArray(resArr);
        int[] resArr1 = shiftZerosTotEndOptimizedAgain(arr);
        PrintData.printArray(resArr1);
    }

    public static int[] shiftZerosTotEndOptimized(int[] nums) {
        int left = 0;
        int right = left + 1;
        while (right < nums.length) {
            if (nums[left] != 0) {
                left++;
                right = left + 1;
            } else {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                    right = left + 1;
                } else {
                    right++;
                }
            }

        }
        return nums;
    }

    public static int[] shiftZerosTotEndOptimizedAgain(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
        }
        return nums;
    }

    public static int[] shiftZerosToForLoop(int[] nums) {
        int l = nums.length;
        int curr = 0;
        for (int i = 0; i < l; i++) {
            if (nums[i] != 0) {
                nums[curr] = nums[i];
                curr++;
            }
        }
        return nums;
    }

    public static int[] shiftZerosTotEndNaive(int[] arr) {
        int l = arr.length;
        int[] res = new int[l];
        int j = 0;
        for (int i = 0; i < l; i++) {
            if (arr[i] > 0) {
                res[j] = arr[i];
                j++;
            }
        }
        return res;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
