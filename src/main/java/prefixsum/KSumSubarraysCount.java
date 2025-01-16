package prefixsum;

import java.util.HashMap;

public class KSumSubarraysCount {
    public static void main(String[] args) {
        int target = 3;
        int[] nums = {1, 2, -1, 1, 2};
        System.out.println(sumBetnRange(nums, target));
    }

    private static int sumBetnRange(int[] nums, int target) {
        int sum = 0;
        HashMap<Integer, Integer> mapp = new HashMap();
        mapp.put(sum, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int compliment = sum - target;
            if (mapp.containsKey(compliment)) {
                count += mapp.get(compliment);
            }
            mapp.put(sum, mapp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
