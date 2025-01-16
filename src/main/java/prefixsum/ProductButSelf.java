package prefixsum;

import utilities.PrintData;

public class ProductButSelf {
    public static void main(String[] args) {
        int[]arr = {2,3,1,4,5}; //60, 40, 120, 30, 24
        int[] res = findAllIntervals(arr);
        PrintData.printArray(res);
    }

    public static int[] findAllIntervals(int[] arr) {
        int[] resArr = new int[arr.length];
        int leftResult = 1;
        for (int i = 0; i < arr.length; i++) {
            resArr[i] = leftResult;
            leftResult *= arr[i];
        }
        PrintData.printArray(resArr);
        int rightResult = 1;
        for (int i = arr.length-1; i >= 0; i--) {
            resArr[i] *= rightResult;
            rightResult *= arr[i];
        }

        return resArr;
     }
}
