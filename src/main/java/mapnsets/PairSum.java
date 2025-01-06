package mapnsets;

import utilities.PrintData;

import java.util.HashMap;

public class PairSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] nums1 = {-1, 3, 4, 2};
        int target = 1;
        int[] resArr = getPairSumBrutForce(nums1, target);
        PrintData.printArray(resArr);
    }

    public static int[] getPairSumBrutForce(int[] nums, int target) {
        int[] resArr = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    resArr[1] = j;
                    resArr[0] = i;
                }
            }
        }
        return resArr;
    }

    public static int[] getPairSumOptimal(int[] nums, int target) {
        int[] resArr = new int[2];
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complimentaryNum = target - nums[i];
            if(numMap.containsKey(complimentaryNum)){
                resArr[1] = i;
                resArr[0] = numMap.get(complimentaryNum);
            }
            numMap.put(nums[i], i);
        }
        return resArr;
    }
}
