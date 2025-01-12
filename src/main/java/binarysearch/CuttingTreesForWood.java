package binarysearch;

public class CuttingTreesForWood {
    public static void main(String[] args) {
        int[] height = {2,6,3,8};
        int k = 7;
        System.out.println("Target level of cutting is: " + cuttingWood(height, k));
    }

    public static int cuttingWood(int[] height, int k) {
        int left = 0;
        int right = 0;
        int requiredHeight = 0;

        for (int i = 0; i < height.length; i++) {
            right = Math.max(height[i], right);
        }
        while (left <= right) {
            int mid = left + (right - left)/2;
            if(woodCollected(height, mid) >= k){
                requiredHeight = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return requiredHeight;
    }

    public static int woodCollected(int[] height, int cutHeight){
        int totalWood = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i] > cutHeight){
                totalWood += height[i] - cutHeight;
            }
        }
        return totalWood;
    }
}
