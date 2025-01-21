package dynamicprgrming;

public class KnapSackProblm {

    private static int knapSack(int capacity, int[] weight, int[] profit, int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col <= capacity; col++) {
                if (weight[row - 1] <= col) {
                    dp[row][col] = Math.max(dp[row-1][col], dp[row-1][col-weight[row-1]] + profit[row-1]);
                } else {
                    dp[row][col] = dp[row - 1][col];
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        int weight[] = {2,3,4,5};
        int profit[] = {1,3,5,6};
        int capacity = 10;
        int n = profit.length;
        System.out.println("Maximum Profit: " + knapSack(capacity, weight, profit, n));
    }
}
