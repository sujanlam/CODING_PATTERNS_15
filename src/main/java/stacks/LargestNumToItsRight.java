package stacks;

import utilities.PrintData;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestNumToItsRight {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3, 2, 3, 2, 4};
        System.out.print("Old Arr: ");
        PrintData.printArray(nums);
        System.out.print("New Arr: ");
        PrintData.printArray(biggestToItsRight(nums));
        System.out.print("Tst Arr: ");
        PrintData.printArray(biggestToItsRightTest(nums));
    }

    public static int[] biggestToItsRight(int[] nums) {
        Stack<Integer> numStack = new Stack<>();
        int[] resArr = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            while(!numStack.isEmpty() && numStack.peek() <= num){
                numStack.pop();
            }
            resArr[i] = !numStack.isEmpty() ? numStack.peek():-1;
            numStack.push(num);
        }

        return resArr;
    }

    public static int[] biggestToItsRightTest(int[] nums) {
        int left = 0;
        int right = 0;

        while (right < nums.length){
            if(nums[right] > nums[left] ){
                nums[left] = nums[right];
                left++;
                right = left+1;
            }else {
                right++;
            }
        }
        nums[nums.length-1] = -1;

        return nums;
    }
}
