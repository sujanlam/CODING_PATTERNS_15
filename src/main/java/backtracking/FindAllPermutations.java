package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPermutations {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,5,6);
        System.out.println(findAllPermutations(nums));
    }

    private static List<List<Integer>> findAllPermutations(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> current, List<Integer> nums) {
        if(current.size() == nums.size()){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int n: nums){
            if(current.contains(n)){
                continue;
            }
            current.add(n);
            backtrack(res, current, nums);
            current.remove(current.size()-1);
        }
    }
}
