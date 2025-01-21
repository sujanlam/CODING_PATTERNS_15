package dynamicprgrming;

public class FibonacciNum {
    public static void main(String[] args) {
        //0 1 1 2 3 5 8 13 21 34 55
        System.out.println(fibNumRecursive(7));
        System.out.println(fibNumRecursiveDP(7));
        System.out.println(fibNumRecursiveVars(10));
    }

    private static int fibNumRecursive(int num) {
        if (num <= 1) {
            return num;
        }
        return fibNumRecursive(num - 1) + fibNumRecursive(num - 2);
    }

    private static int fibNumRecursiveDP(int num) {
        if (num <= 1) {
            return num;
        }

        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[num];
    }

    private static int fibNumRecursiveVars(int num) {
        if (num <= 1) {
            return num;
        }
        int a = 0;
        int b = 1;
        int current = 0;

        for (int i = 2; i <= num; i++) {
            current = a + b;
            a = b;
            b = current;
        }
        return current;
    }

}
