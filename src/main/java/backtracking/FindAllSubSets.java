package backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubSets {
    public static void main(String[] args) {
        int[] nums = {4,5,6};
        List<List<Integer>> res = allSubsets(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> allSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsBackTrack(0, new ArrayList(), res, nums);
        return res;
    }

    public static void subsetsBackTrack(int startIndex, List<Integer> current, List<List<Integer>> res, int[] nums) {
        if (startIndex > nums.length) {
            return;
        }
        res.add(new ArrayList<>(current));
        for (int i = startIndex; i < nums.length; i++) {
            current.add(nums[i]);
            subsetsBackTrack(i+1, current, res, nums);
            current.removeLast();
        }
    }
}
