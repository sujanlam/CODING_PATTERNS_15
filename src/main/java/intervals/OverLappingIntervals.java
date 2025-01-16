package intervals;

import utilities.PrintData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverLappingIntervals {
    public static void main(String[] args) {
        int[][] first = {{1,4},{5,6},{9,10}};
        int[][] second = {{2,7},{8,9}};
        PrintData.printDoubleDimArray(first);
        int[][] resIntervals = findAllIntervals(first, second);
        PrintData.printDoubleDimArray(resIntervals);
    }

    public static int[][] findAllIntervals(int[][] first, int[][] second) {
        List<int[]> resList = new ArrayList<>();
        Arrays.sort(first, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(second, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        int j = 0;
        int maxOverlaps = first.length + second.length;
        int[][] result = new int[maxOverlaps][2];
        int count = 0;
        while (i < first.length && j < second.length){
            int[] interval1 = first[i];
            int[] interval2 = second[j];

            //Start of B should be smaller than End of A
            //Start of A should be smaller than end of B
            if (interval1[1] >= interval2[0] && interval1[0] <= interval2[1]){
                result[count] = new int[] {Math.max(interval1[0], interval2[0]), Math.min(interval1[1], interval2[1])};
                count++;
            }
            if(interval1[1] < interval2[1]){
                i++;
            }else {
                j++;
            }
        }
        return Arrays.copyOf(result, count);
     }
}
