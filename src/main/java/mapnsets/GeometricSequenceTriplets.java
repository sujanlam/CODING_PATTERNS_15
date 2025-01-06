package mapnsets;

import java.util.HashMap;
import java.util.Map;

public class GeometricSequenceTriplets {
    public static void main(String[] args) {
        int[] num = {2,1,2,4,8,8};
        int r = 2;
        System.out.println(countTriplets(num, r));
    }

    public static int countTriplets(int[] nums, int r){
        int count = 0;
        Map<Integer, Integer> mainMap = new HashMap<>();
        Map<Integer, Integer> assistMap = new HashMap<>();

        for(int num: nums){
            mainMap.put(num, mainMap.getOrDefault(num, 0)+1);
        }
        System.out.println(mainMap);

        for (int n: nums) {
            mainMap.put(n, mainMap.get(n)-1);
            if(n % r == 0){
                count += assistMap.getOrDefault(n/r, 0) * mainMap.getOrDefault(n*r, 0);
            }
            assistMap.put(n, assistMap.getOrDefault(n,0) +1);
        }

        return count;
    }
}
