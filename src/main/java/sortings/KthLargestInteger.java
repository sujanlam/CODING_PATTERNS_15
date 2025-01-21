package sortings;

import java.util.PriorityQueue;

public class KthLargestInteger {
    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 3, 1, 6};
        //6 5 4 3 2 1
        int target = 2;
        System.out.println(findKthLargest(nums, target));
    }

    private static int findKthLargest(int[] nums, int target) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > target) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
