package solveissues;

import utilities.PrintData;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,3,3,3,4};

        int res = removeDups(nums);
        System.out.println(res);
    }

    private static int removeDups(int[] nums) {
        int current = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[current-1]) {
                nums[current] = nums[right];
                current++;
            }
        }
        return current;
    }
}

