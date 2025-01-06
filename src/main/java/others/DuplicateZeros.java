package others;

import utilities.PrintData;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] nums = {1,0,2,3,0,4,5,0};
        int[] res = duplicateZeroes(nums);
        PrintData.printArray(res);
    }

    public static int[] duplicateZeroes(int[] arr){
        int[] resArr = new int[arr.length];
        int curr = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] == 0){
                resArr[curr] = 0;
                curr++;
                resArr[curr] = 0;
                curr++;
            }else {
                resArr[curr] = arr[i];
                curr++;
            }
            if(curr == resArr.length){
                break;
            }

        }
        return resArr;
    }
}
