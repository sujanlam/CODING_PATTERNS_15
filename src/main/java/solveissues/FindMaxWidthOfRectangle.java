package solveissues;

import java.util.Stack;

public class FindMaxWidthOfRectangle {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.println(getMaxWidthOfRectangle(nums));
    }

    private static int getMaxWidthOfRectangle(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < stack.peek()) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i-stack.peek() -1;
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
