package twopointers;

public class MaxWaterCollected {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxWater = 0;
        int n = height.length;

        int left = 0;
        int right = n - 1;
        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            int waterCollected =  (minHeight * (right-left));
            maxWater = Math.max(waterCollected, maxWater);
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }

        return maxWater;
    }
}
