import utilities.PrintData;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortByPrimeEvenOdd {
    public static void main(String[] args) {
        int[] nums = {11, 4, 6, 5, 8, 7, 10, 9};
        PrintData.printArray(nums);;
        PrintData.printArray(sortByPrEvOdd(nums));
        System.out.println(isPrime(11));
    }
    public static int[] sortByPrEvOdd(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int count=0;
        for (int i = 0; i < n; i++) {
            if(isPrime(nums[i])){
                res[count] = nums[i];
                set.add(nums[i]);
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] % 2 != 0 && !set.contains(nums[i])){
                res[count] = nums[i];
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] %2==0){
                res[count] = nums[i];
            }
        }

        return res;
    }

    private static boolean isPrime(int num) {
        if(num <= 1){
            return false;
        }
        if(num <= 3){
            return true;
        }
        if(num %2==0 || num % 3 == 0){
            return false;
        }
        for (int i = 5; i*i <= num; i+=6) {
            if(num % i == 0 || num % (i+2)==0){
                return false;
            }
        }
        return true;
    }
}
