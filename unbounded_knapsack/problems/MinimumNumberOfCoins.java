package unbounded_knapsack.problems;

// You are given an integer array coins[] of size N representing coin denominations, and an integer amount representing the total sum.
// You have infinite supply of each coin (unbounded).
// You need to determine the minimum number of coins required to make the given amount.
// If it is not possible to make the amount, return -1.

public class MinimumNumberOfCoins {
    public static int findMinimumCoins(int[] coins, int n, int amount) {
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < amount + 1; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        for (int j = 1; j < amount + 1; j++) {
            dp[1][j] = (j % coins[0] == 0) ? j / coins[0] : Integer.MAX_VALUE - 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < amount + 1; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                }
            }
        }
        return dp[n][amount] != Integer.MAX_VALUE - 1 ? dp[n][amount] : -1;
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int n = coins.length;
        int amount = 7;
        System.out.println(findMinimumCoins(coins, n, amount));
    }
}
