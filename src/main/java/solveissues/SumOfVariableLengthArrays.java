package solveissues;

import utilities.PrintData;

import java.util.HashMap;

public class SumOfVariableLengthArrays {
    public static void main(String[] args) {
        int[] nums1 = {2,3,1};
        int[] nums = {3,1,1,2};
        System.out.println(findSum1(nums));
    }
    private static int findSum1(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        int[] prefixSum = new int[n + 1]; // Prefix sum array

        // Calculate the prefix sum of the array
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Calculate the total sum using the prefix sum array
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]);
            totalSum += prefixSum[i + 1] - prefixSum[start];
        }

        return totalSum;
    }

    private static int findSum(int[] nums) {
        int totalSum = 0;
        int i = 0;
        int start = 0;
        while (i<nums.length){
            for (int j = start; j <= i; j++) {
                totalSum += nums[j];
            }
            i++;
            start = i< nums.length?Math.max(0, i-nums[i]):nums.length+1;
        }
        return totalSum;
    }
}
