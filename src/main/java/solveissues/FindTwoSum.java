package solveissues;

import utilities.PrintData;

import java.util.HashMap;

public class FindTwoSum {
    public static void main(String[] args) {
        int[] nums = {7,3,2,9,1,12};
        int target = 18;
        PrintData.printArray(findTwoSum(nums, target));
    }

    private static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
             if(mapp.containsKey(temp)){
                 return new int[]{mapp.get(temp), i};
             }else {
                 mapp.put(nums[i], i);
             }
        }
        return new int[]{-1,-1};
    }
}
