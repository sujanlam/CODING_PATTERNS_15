package stacks;

import utilities.PrintData;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MaximumsOfSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1, 2, 1, 1};
        int k = 4;
        PrintData.printArray(maxOfSlidWindow(nums,k));
        PrintData.printArray(maxOfSlidWindowOptimized(nums,k));
    }

    public static int[] maxOfSlidWindowOptimized(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length-k+1;
        int[] resArr = new int[n];
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (!deque.isEmpty() && deque.peek() <= nums[right]) {
                deque.pop();
            }
            deque.push(nums[right]);
            if(right-left+1 == k) {
                if(!deque.isEmpty()){

            }
        }


            resArr[left] = deque.pollLast();
        }
        return resArr;
    }

    public static int[] maxOfSlidWindow(int[] nums, int k) {
        int[] resArr = new int[nums.length-k+1];
        int max = 0;
        for (int i = 0; i < nums.length - k+1; i++) {
            max = nums[i];
            for (int j = i; j <= k; j++) {
                int b = nums[j];
                max = Math.max(max, b);
            }
            resArr[i] = max;
        }

        return resArr;
    }
}
