package backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubSets {
    public static void main(String[] args) {

    }
    public List<List<Integer>> subsetsBackTrack(int[] nums, List<Integer> current, List<List<Integer>> res, int start) {

        res.add(new ArrayList<>(current));
        for (int i = 0; i < nums.length; i++) {
            current.add(nums[i]);
            subsetsBackTrack(nums, current, res, i+1);
            current.remove(current.size()-1);
        }
        return res;
    }
}
