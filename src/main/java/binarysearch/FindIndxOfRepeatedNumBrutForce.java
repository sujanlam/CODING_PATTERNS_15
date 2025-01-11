package binarysearch;

import utilities.PrintData;

public class FindIndxOfRepeatedNumBrutForce {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 12, 14, 14, 14, 19};
        int target = 14;
        PrintData.printArray(findBothBoundsBrutForce(nums, target));
    }

    private static int[] findBothBoundsBrutForce(int[] nums, int target) {
        int[] arr = new int[2];
        int a = 0;
        int b = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target && arr[0]==0){
                arr[0] = i;
            } else if (arr[0]>0 && nums[i]==target) {
                arr[1] = i;
            }
        }
        return arr;
    }
}
